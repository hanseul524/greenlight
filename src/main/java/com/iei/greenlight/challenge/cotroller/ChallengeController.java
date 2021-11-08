package com.iei.greenlight.challenge.cotroller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.iei.greenlight.challenge.domain.CFile;
import com.iei.greenlight.challenge.domain.PageInfo;
import com.iei.greenlight.challenge.domain.Challenge;
import com.iei.greenlight.challenge.service.ChallengeService;
import com.iei.greenlight.common.Pagination;

@Controller
public class ChallengeController {
	
	@Autowired
	private ChallengeService service;

	// 챌린지 글쓰기 폼 보여주기
	@RequestMapping(value="ChallengeWriteview.do", method=RequestMethod.GET)
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
				return "redirect:ChallengeWriteView.do";
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
}
