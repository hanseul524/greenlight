package com.iei.greenlight.challenge.cotroller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
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
import com.iei.greenlight.challenge.domain.Category;
import com.iei.greenlight.challenge.domain.ChLike;
import com.iei.greenlight.challenge.domain.PageInfo;
import com.iei.greenlight.challenge.domain.Reply;
import com.iei.greenlight.challenge.domain.Challenge;
import com.iei.greenlight.challenge.service.ChallengeService;
import com.iei.greenlight.common.AdminChPagination;
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
			int cNo = service.selectCategory();
			challenge.setCategoryNo(cNo);
			System.out.println(cNo);
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
				return "redirect:ChallengeListView.do?check=recent";
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
			@RequestParam(value="check") String check,
			@RequestParam(value="page", required=false) Integer page) {
		if(check == null) {
			check = "recent";
		}
		HashMap<String, Object> hashmap = new HashMap<String, Object>();
		hashmap.put("check", check);
		int currentPage = (page != null) ? page : 1;
		int totalCount = service.getListCount(hashmap);
		PageInfo pi = Pagination.getPageInfo(currentPage, totalCount);
		hashmap.put("pi", pi);
		List<Challenge> cList = service.printAll(hashmap);
		System.out.println(pi.toString());
		System.out.println(check);
		System.out.println("챌린지 리스트:" + cList.toString());
		int likeCount = 0;
		
		if(!cList.isEmpty()) {
			model.addAttribute("cList", cList);
			int categoryNo = cList.get(0).getCategoryNo();
			System.out.println("글번호:" + categoryNo);
			Category category = service.printCategoryTitle(categoryNo);
			if( category != null) {
				System.out.println("넘어온 카테고리 " +category.toString());
				model.addAttribute("category", category);
			}
			model.addAttribute("pi", pi);
			model.addAttribute("check", check);
			return "challenge/ChallengeListView";
		}else {
			model.addAttribute("msg", "리스트 조회 실패");
			return "common/errorPage";
		}
	}
	
	@RequestMapping(value="chSearch.do", method=RequestMethod.GET)
	public String ChallengeSearchView(
			@RequestParam("search-title") String chTitle) {
		
		return "";
	}
	
	
	// 관리자 페이지 챌린지 리스트 조회
	@RequestMapping(value="AdminChList.do", method=RequestMethod.GET)
	public String AdminChListView(
			@ModelAttribute Challenge challenge,
			HttpServletRequest request,
			Model model,
			@RequestParam(value="page", required=false) Integer page) {
		int currentPage = (page != null) ? page : 1;
		int totalCount = service.getAdminListCount();
		PageInfo api = AdminChPagination.getPageInfo(currentPage, totalCount);
		List<Challenge> cList = service.printAllCh(api);
		System.out.println(cList.toString());
		if(!cList.isEmpty()) {
			model.addAttribute("cList", cList);
			model.addAttribute("api", api);
			return "admin/adminCh";
		}else {
			model.addAttribute("msg", "리스트 조회 실패");
			return "common/errorPage";
		}
	}
	// 관리자 페이지 팝업창 뷰
	@RequestMapping(value="/ChPopupView.do", method=RequestMethod.GET)
	public String AdminChPopupView() {
		return "admin/chPopup";
	}
	// 관리자 페이지 챌린지 오픈 
	@ResponseBody
	@RequestMapping(value="ChOpen.do", method=RequestMethod.POST)
	public String AdminChOpen(@RequestParam("chCategory") String chCategory,
			@ModelAttribute Category category,
			Model model
			) {
		category.setChCategory(chCategory);
		System.out.println(chCategory.toString());
		int result = service.registerCategory(category);
		if(result > 0) {
			return "success";
		}else {
			return "error";			
		}
	}
	
	// 관리자 페이지 챌린지 승인
	@ResponseBody
	@RequestMapping(value="challengeConfirm.do", method=RequestMethod.POST)
	public String ChallengeConfirm(@RequestParam("chNo") int chNo,
			@RequestParam("userId") String userId) {
		String pointContents = "챌린지 승인";
		int pointPayment = 100;
		HashMap<String, Object> hashmap = new HashMap<String, Object>();
		hashmap.put("chNo", chNo);
		hashmap.put("userId", userId);
		hashmap.put("pointContents", pointContents);
		hashmap.put("pointPayment", pointPayment);
		int result = service.confirmChallenge(hashmap);
		System.out.println(hashmap.toString());
		if(result > 0) {
			service.modifyChPoint(hashmap);
			return "success";
		}else {
			return "fail";
		}
	}
	
	// 챌린지 디테일 페이지
	@RequestMapping(value="ChallengeDetail.do", method=RequestMethod.GET)
	public String ChallengeDetail(
			@RequestParam("chNo") int chNo,
			Model model,
			HttpServletRequest request
			) {
		try {
			String userId = (String)request.getSession().getAttribute("userId");
			int likeCk = 0;
			System.out.println(userId);
			Challenge challenge = service.printOne(chNo);
			if(challenge != null) {
				List<CFile> cList = service.printOneImg(chNo);
				model.addAttribute("challenge", challenge);
				model.addAttribute("cList", cList);
				// 로그인했을때
				if(userId != null) {
					HashMap<String, Object> hashMap = new HashMap<String, Object>();
					hashMap.put("userId", userId);
					hashMap.put("chNo", chNo);
					hashMap.put("likeCk", likeCk);
					System.out.println(hashMap.toString());
					ChLike chlike = service.LikeCk(hashMap);
					// chlike테이블에 유저의 정보가 있을 때
					if(chlike != null) {
						System.out.println("테이블에 유저 정보 있을 때 " + chlike.toString());
						model.addAttribute("chlike", chlike);
						return "challenge/ChallengeDetailView2";
					}else { //테이블에 유저 정보가 없을때 insert
						int result = service.addLike(hashMap);
						if(result > 0) {
							chlike = service.LikeCk(hashMap);
							model.addAttribute("chlike", chlike);
							return "challenge/ChallengeDetailView2";
						}
					}
				}
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
	
	// 좋아요 추가
	@ResponseBody
	@RequestMapping(value="addLike.do", method=RequestMethod.POST)
	public String addLike(@ModelAttribute ChLike chlike,
			@ModelAttribute Challenge challenge,
			HttpServletRequest request,
			Model model) {
		int likeCk = 1;
		chlike.setUserId((String)request.getSession().getAttribute("userId"));
		chlike.setLikeCk(likeCk);
		int result = service.updateLike(chlike);
		System.out.println("좋아요 눌렀을 때"+ chlike.toString());
		System.out.println(result);
		if(result > 0) {
			int likeCount = 0;
			challenge.setLikeCount(likeCount);
			likeCount = service.updateLikeCount(challenge);
			if(likeCount > 0) {
				model.addAttribute("challenge", challenge);
			}
			model.addAttribute("chlike", chlike);
			System.out.println("누른 결과값" + chlike.toString());
			return "success";
		}else {
			return "fail";
		}
	}
	
	// 좋아요 취소
	@ResponseBody
	@RequestMapping(value="removeLike.do", method=RequestMethod.POST)
	public String delLike(@ModelAttribute ChLike chlike,
			@ModelAttribute Challenge challenge,
			HttpServletRequest request,
			Model model) {
		chlike.setUserId((String)request.getSession().getAttribute("userId"));
		System.out.println(chlike.toString());
		int result = service.removeLike(chlike);
		System.out.println(result);
		if(result > 0) {
			int likeCount = 0;
			challenge.setLikeCount(likeCount);
			likeCount = service.removeLikeCount(challenge);
			if(likeCount > 0) {
				model.addAttribute("challenge", challenge);
			}
			System.out.println(chlike.toString());
			model.addAttribute("chlike", chlike);
			return "success";
		}else {
			return "fail";
		}
	}
	
	// 챌린지 삭제
	@RequestMapping(value="ChallengeDelete.do", method=RequestMethod.GET)
	public String ChallengeDelete(
			@RequestParam("chNo") int chNo,
			HttpServletRequest request,
			Model model) {
		System.out.println(chNo);
		List<CFile> cList = service.printImgDel(chNo);
		if(!cList.isEmpty()) {
			for(int i=0; i<cList.size(); i++) {
				deleteFile(cList.get(i).getFileName(), request);
			}
		}
		int result = service.removeChallenge(chNo);
		System.out.println(result);
		if(result > 0) {
			return "redirect:ChallengeListView.do";
		}else {
			model.addAttribute("msg", "게시글 삭제 실패");
			return "common/errorPage";
		}
	}
	
	// 파일 삭제
	public void deleteFile(String fileName, HttpServletRequest request) {
		System.out.println(345);
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
			System.out.println("댓글 데이터 전송 실패");
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
	
	//마이페이지챌린지
	   @RequestMapping(value="myChallenge.do", method=RequestMethod.GET)
	   public String myChallenge(@ModelAttribute Challenge challenge, Model model, HttpServletRequest request, @RequestParam(value="page", required=false) Integer page) {
	      String userId = (String)request.getSession().getAttribute("userId");
	      int currentPage = (page != null) ? page : 1;
	      int totalCount = service.getMyListCount(userId);
	      PageInfo pi = Pagination.getPageInfo(currentPage, totalCount);
	      HashMap<String, Object> hashMap = new HashMap<String, Object>();
	      hashMap.put("pi", pi);
	      hashMap.put("userId", userId);
	      List<Challenge> challenges = service.printChallList(hashMap);
	      if(!challenges.isEmpty()) {
	            model.addAttribute("cList", challenges);
	            model.addAttribute("pi", pi);
	            model.addAttribute("userId", userId);
	            return "mypage/MyChallenge";
	         }else {
	            model.addAttribute("cList", null);
	            return "mypage/MyChallenge";
	         }
	   }
}
