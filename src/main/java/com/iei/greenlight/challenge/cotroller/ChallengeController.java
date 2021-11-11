package com.iei.greenlight.challenge.cotroller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.iei.greenlight.challenge.domain.CFile;
import com.iei.greenlight.challenge.domain.ChLike;
import com.iei.greenlight.challenge.domain.PageInfo;
import com.iei.greenlight.challenge.domain.Reply;
import com.iei.greenlight.challenge.domain.Challenge;
import com.iei.greenlight.challenge.service.ChallengeService;
import com.iei.greenlight.common.Pagination;

@Controller
public class ChallengeController {
	
	@Autowired
	private ChallengeService service;

	
	// 챌린지 글쓰기 폼 보여주기
	@RequestMapping(value="/ChallengeWriteview.do", method=RequestMethod.GET)
	public String ChallengeWriteView() {
		return "challenge/ChallengeWriteForm";
	}
	
	// 챌린지 글 등록
	@RequestMapping(value="ChallengeRegister.do", method=RequestMethod.POST)
	public String registerChallenge(
			@ModelAttribute Challenge challenge,
			@RequestParam("editordata") String chContents,
			Model model,
			MultipartHttpServletRequest multirequest,
			HttpServletRequest request
			) {
		challenge.setChContents(chContents);
		challenge.setChWriter((String)request.getSession().getAttribute("userId")); //세션에서 id값 가져오기
		try {
			int result = service.registerChallenge(challenge);
			List<CFile> cList = null;
			if(result > 0) {
				cList = new ArrayList<CFile>();
				String root = request.getSession().getServletContext().getRealPath("resources"); //파일 저장경로
				String savePath = root + "\\cuploadFiles"; //파일 저장폴더
				
				File folder = new File(savePath);
				if(!folder.exists()) {
					folder.mkdir(); //폴더 생성
				}
				// 넘어온 파일 리스트로 저장
				List<MultipartFile> mf = multirequest.getFiles("uploadFile");
				if(mf.size() == 1 && mf.get(0).getOriginalFilename().equals("")) {
					
				}else { //mf에 파일이 업로드 될 때
					for(int i=0; i<mf.size(); i++) {
						String fileName = mf.get(i).getOriginalFilename();
						String filePath = folder + "\\" + fileName; //파일경로
						CFile cfile = new CFile();
						
						cfile.setCategoryNo(challenge.getCategoryNo());
						cfile.setChNo(challenge.getChNo());
						cfile.setChWriter(challenge.getChWriter());
						cfile.setFileName(fileName);
						cfile.setFilePath(filePath);
						cfile.setFileSize(mf.get(i).getSize());
						cList.add(cfile);
						try {
							mf.get(i).transferTo(new File(filePath));//파일 저장하기
						} catch (IllegalStateException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
				cList.get(0).setFileMain("Y");
				int imgresult = service.registerChImage(cList);
				System.out.println("파일 등록 성공");
				return "redirect:ChallengeListView.do";
			}else {
				model.addAttribute("msg", "글 등록 실패");
				return "common/errorPage";
			}
		}catch(Exception e) {
			e.printStackTrace();
			model.addAttribute("mgs", e.toString());
			return "common/errorPage";
		}
	}
	
//	// 파일 저장
//	public CFile saveFile(MultipartFile uploadFile, HttpServletRequest request ) {
//		
//		String root = request.getSession().getServletContext().getRealPath("resources");
//		String savePath = root + "\\cuploadFiles";
//		File folder = new File(savePath);
//		if(!folder.exists()) {
//			folder.mkdir();
//		}
//		String filePath = folder + "\\" + uploadFile.getOriginalFilename();
//		String fileName = uploadFile.getOriginalFilename();
//		
//		try {
//			uploadFile.transferTo(new File(filePath));
//		} catch (IllegalStateException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		CFile cfile = new CFile(fileName, filePath);
//		return cfile;
//	}
	
	// 챌린지 리스트 뷰 + 페이징 처리
	@RequestMapping(value="ChallengeListView.do", method=RequestMethod.GET)
	public String ChallengeListView(
			@ModelAttribute Challenge challenge,
			HttpServletRequest request,
			Model model,
			@RequestParam(value="page", required=false) Integer page) {
		int currentPage = (page != null) ? page : 1;
		int totalCount = service.getListCount();
		PageInfo pi = Pagination.getPageInfo(currentPage, totalCount);
		List<Challenge> cList = service.printAll(pi);
		if(!cList.isEmpty()) {
			model.addAttribute("cList", cList);
			model.addAttribute("pi", pi);
			return "challenge/ChallengeListView";
		}else {
			model.addAttribute("msg", "리스트 조회 실패");
			return "common/errorPage";
		}
	}
	
	// 챌린지 디테일 페이지
	@RequestMapping(value="ChallengeDetail.do", method=RequestMethod.GET)
	public String ChallengeDetail(
			@RequestParam("chNo") int chNo,
			Model model
			) {
		try {
			Challenge challenge = service.printOne(chNo);
			if(challenge != null) {
				List<CFile> cList = service.printOneImg(chNo);
				model.addAttribute("challenge", challenge);
				model.addAttribute("cList", cList);
				return "challenge/ChallengeDetailView";
			}else {
				model.addAttribute("msg", "상세 조회 실패");
				return "common/errorPage";
			}			
		}catch(Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.toString());
			return "common/errorPage";
		}	
	}
	
	// 챌린지 삭제
	@RequestMapping(value="ChallengeDelete.do", method=RequestMethod.GET)
	public String ChallengeDelete(
			@RequestParam("chNo") int chNo,
			@RequestParam("fileName") String fileName,
			HttpServletRequest request,
			Model model) {
		int result = service.removeChallenge(chNo);
		if(result > 0) {
			if(fileName != "") {
				deleteFile(fileName, request);
			}
			return "redirect:ChallengeListView.do";
		}else {
			model.addAttribute("msg", "게시글 삭제 실패");
			return "common/errorPage";
		}
	}
	
	// 파일 삭제 ~~
	public void deleteFile(String fileName, HttpServletRequest request) {
		String root = request.getSession().getServletContext().getRealPath("resources");
		String fullPath = root + "\\cuploadFiles";
		File file = new File(fullPath + "\\" + fileName);
		if(file.exists()) {
			file.delete();
		}
	}
	// 게시글 수정 뷰
	@RequestMapping(value="ChallengeModify.do")
	public String ChallengeModifyView(
			@RequestParam("chNo") int chNo,
			Model model) {
		Challenge challenge = service.printOne(chNo);
		if(challenge != null) {
			model.addAttribute("challenge", challenge);
			return "challenge/ChallengeModify";
		}else {
			model.addAttribute("msg", "게시글 조회 실패");
			return "common/errorPage";
		}
	}
	// 게시글 수정
	@RequestMapping(value="ChallengeUpdate.do", method=RequestMethod.POST)
	public String ChallengeModify(
			@ModelAttribute Challenge challenge,
			@RequestParam("editordata") String chContents,
//			@RequestParam("fileName") String fileName,
			Model model,
			HttpServletRequest request) {
		try {
			challenge.setChWriter((String)request.getSession().getAttribute("userId"));
			challenge.setChContents(chContents);
			System.out.println(challenge);
//		challenge.setFileName(fileName);
			int result = service.modifyChallenge(challenge);
			if (result > 0) {
//			if(fileName != null) {
//				
//			}	
				model.addAttribute("chNo", challenge.getChNo());
				System.out.println(challenge);
			} else {
				model.addAttribute("msg", "글 수정 실패");
				return "common/errorPage";
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.toString());
		}
		return "redirect:ChallengeDetail.do";
	}
	
	// 댓글 등록
	@ResponseBody
	@RequestMapping(value="addReply.do", method=RequestMethod.POST)
	public String addReply(@ModelAttribute Reply reply,
			HttpServletRequest request) {
		reply.setReplywriter((String)request.getSession().getAttribute("userId"));
		System.out.println(reply.getReplywriter());
		System.out.println(reply);
		int result = service.registerReply(reply);
		System.out.println(result);
		if(result > 0) {
			
			return "success";
		}else {
			return "fail";
		}
	}
	
	// 댓글 리스트 출력
	@ResponseBody
	@RequestMapping(value="replyList.do", method=RequestMethod.GET)
	public void getReplyList(@RequestParam("chNo") int chNo,
			HttpServletResponse response) throws JsonIOException, IOException {
		List<Reply> rList = service.printAll(chNo);
		System.out.println(rList);
		if(!rList.isEmpty()) {
			Gson gson = new GsonBuilder().setDateFormat("yyyy.MM.dd").create(); // replyDate 데이터포멧으로 출력
			gson.toJson(rList, response.getWriter());
		}else {
			System.out.println("데이터 전송 실패");
		}
	}
	
	// 댓글 수정
	@ResponseBody
	@RequestMapping(value="modifyReply.do", method=RequestMethod.POST)
	public String updateReply(@ModelAttribute Reply reply) {
		int result = service.modifyReply(reply);
		if(result > 0) {
			return "success";
		}else {
			return "fail";
		}
	}
	// 댓글 삭제
	@ResponseBody
	@RequestMapping(value="deleteReply.do", method=RequestMethod.GET)
	public String deleteReply(@ModelAttribute Reply reply) {
		int result = service.removeReply(reply);
		System.out.println(result);
		if(result > 0) {
			return "success";
		}else {
			return "fail";
		}
	}
	@ResponseBody
	@RequestMapping(value="addLike.do", method=RequestMethod.POST)
	public String addLike(@ModelAttribute ChLike chlike,
			HttpServletRequest request) {
		System.out.println(chlike.toString());
		chlike.setUserId((String)request.getSession().getAttribute("userId"));
		int result = service.addLike(chlike);
		System.out.println(result);
		if(result > 0) {
			System.out.println(chlike);
			return "success";
		}else {
			return "fail";
		}
	}
	
	@ResponseBody
	@RequestMapping(value="removeLike.do", method=RequestMethod.POST)
	public String delLike(@ModelAttribute ChLike chlike,
			HttpServletRequest request,
			Model model) {
		chlike.setUserId((String)request.getSession().getAttribute("userId"));
		int result = service.removeLike(chlike);
		if(result > 0) {
			model.addAttribute("chlike", chlike);
			return "success";
		}else {
			return "fail";
		}
	}
}
