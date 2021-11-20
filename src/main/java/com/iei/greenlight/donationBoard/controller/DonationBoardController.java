package com.iei.greenlight.donationBoard.controller;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.iei.greenlight.donationBoard.common.donationBoardPagination;
import com.iei.greenlight.donationBoard.domain.Donation;
import com.iei.greenlight.donationBoard.domain.DonationBoard;
import com.iei.greenlight.donationBoard.domain.DonationReply;
import com.iei.greenlight.donationBoard.domain.DtFile;
import com.iei.greenlight.donationBoard.domain.PageInfo;
import com.iei.greenlight.donationBoard.service.DonationBoardService;

@Controller
public class DonationBoardController {

	@Autowired
	private DonationBoardService service;
	// 기부게시판 글 작성 view
	@RequestMapping(value="donationBoardWriteView.do", method=RequestMethod.GET)
	public String donationBoardWriteView() {
		return "donation/donationBoardWrite";
	}
	
	// 기부게시글 등록
	@RequestMapping(value="donationboardWrite.do", method=RequestMethod.POST)
	public String donationBoardWrite(@ModelAttribute DonationBoard db, @RequestParam("editordata") String dtContents, @RequestParam("uploadFile") MultipartFile[] uploadFiles,HttpServletRequest request) {
		db.setDtContents(dtContents);
		db.setWriterId((String)request.getSession().getAttribute("userId"));
		List<DtFile> dFList = null;
		int result = service.registerdonationBoard(db);
		int boardNo = db.getBoardNo();
		
		if(result > 0) {
			dFList = new ArrayList<DtFile>();
			for(MultipartFile uploadFile : uploadFiles) {
				if(!uploadFile.getOriginalFilename().equals("")) {
					DtFile dt = saveFile(uploadFile, request,boardNo);
					dt.setFileMain("N");
					dFList.add(dt);
				}
			}
			dFList.get(0).setFileMain("Y");
			int image = service.registerDtFile(dFList);
			return "redirect:main.do";
		}else {
			return"user/error";
		}
	}
	
	// 이클립스 파일 저장.
	public DtFile saveFile(MultipartFile uploadFile, HttpServletRequest request, int boardNo) {
		String root = request.getSession().getServletContext().getRealPath("resources");
		String savePath = root + "\\donationUploadFiles";
		File folder = new File(savePath);
		DtFile dtFile = new DtFile();
		if(!folder.exists()) {
			folder.mkdir();
		}
		String filePath = folder + "\\" + uploadFile.getOriginalFilename();
		String fileName = uploadFile.getOriginalFilename();
		
		try {
			uploadFile.transferTo(new File(filePath));
		}catch(IllegalStateException e){
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			dtFile.setBoardNo(boardNo);
			dtFile.setFileName(fileName);
			dtFile.setFilePath(filePath);
			dtFile.setFileSize(uploadFile.getSize());
		}
		return dtFile;
	}
	
	// 기부게시판 리스트
	@RequestMapping(value="donationBoardList.do", method=RequestMethod.GET)
	public String donationBoardListView(Model model, HttpServletRequest request, @RequestParam(value="page", required=false) Integer page) {
		int currentPage = (page != null) ? page : 1;
		int totalCount = service.getListCount();
		PageInfo pi = donationBoardPagination.getPageInfo(currentPage, totalCount);
		List<DonationBoard> dList = service.printAll(pi);
		if(!dList.isEmpty()) {
			for(int i = 0; i < dList.size(); i++) {
				double dtTargetAmount = dList.get(i).getDtTargetAmount();
				double donationAmount = dList.get(i).getDonationAmount();
				double ac = (donationAmount / dtTargetAmount) * 100;
				double achievement = Math.floor(ac * 100) / 100.0;
				dList.get(i).setAchievement(achievement);
			}
			model.addAttribute("dList", dList);
			model.addAttribute("pi", pi);
			return "donation/donationBoardList";
		}else {
			return "user/error";
		}
		
	}
	
	@RequestMapping(value="donationBoardDetail.do", method=RequestMethod.GET)
	public String donationBoardDetailView(@RequestParam("boardNo") int boardNo, Model model, HttpServletRequest request) {
		DonationBoard board = service.printDonationBoardOne(boardNo);
		List<DtFile> dFList = null;
		List<Donation> dList = null;
		if(board != null) {
			double dtTargetAmount = board.getDtTargetAmount();
			double donationAmount = board.getDonationAmount();
			double ac = (donationAmount / dtTargetAmount) * 100;
			double achievement = Math.floor(ac * 100) / 100.0;
			board.setAchievement(achievement);
			dFList = service.printAllDonationBoardImageOneByNo(boardNo);
			dList = service.printDonationUserRanking(boardNo);
			model.addAttribute("board", board);
			model.addAttribute("dFList", dFList);
			model.addAttribute("dList", dList);
			return "donation/donationBoardDetail";
		}else {
			return "user/error";
		}
	}
	
	// 회원 기부
	@RequestMapping(value="donation.do", method=RequestMethod.POST)
	public String donation(@RequestParam("donationPoint") int donationPoint,@RequestParam("boardNo") int boardNo , HttpServletRequest request) {
		String userId = (String)request.getSession().getAttribute("userId");
		// 회원 포인트 차감
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("userId", userId);
		map.put("donationPoint", donationPoint);
		System.out.println(donationPoint);
		int uResult = service.donationUserPoint(map);
		// 도네이션 테이블에 insert
		Donation donation = new Donation();
		donation.setUserId(userId);
		donation.setDonationPoint(donationPoint);
		donation.setBoardNo(boardNo);
		service.registerDonation(donation);
		// 도네이션 보드 달성금액 수정
		DonationBoard db = new DonationBoard();
		db.setBoardNo(boardNo);
		db.setDonationAmount(donationPoint);
		service.updateDonationBoardDonationAmount(db);
		return "redirect:donationBoardDetail.do?boardNo=" + boardNo;
	}
	//마이페이지 내가 기부한 기부글 리스트
	   @RequestMapping(value="myDonation.do", method=RequestMethod.GET)
	   public String myDonationList(HttpSession session, Model model, @RequestParam(value="page", required=false) Integer page) {
	      String userId = (String) session.getAttribute("userId");
	      int currentPage = (page != null) ? page : 1;
	      int totalCount = service.getListCount();
	      PageInfo pi = donationBoardPagination.getPageInfo(currentPage, totalCount);
	      HashMap<String, Object> hashMap = new HashMap<String, Object>();
	      hashMap.put("pi", pi);
	      hashMap.put("userId", userId);
	      List<DonationBoard> dList = service.myPrintList(hashMap);
	      System.out.println(dList.toString());
	      if(!dList.isEmpty()) {
	         model.addAttribute("dList", dList);
	         model.addAttribute("pi", pi);
	         return "mypage/MyDonation";
	      }else {
	         model.addAttribute("dList", null);
	         return "mypage/MyDonation";
	      }
	   }
	   // 기부게시판 댓글 등록
	   @ResponseBody
	   @RequestMapping(value="donationBoardAddReply.do", method=RequestMethod.POST)
	   public String donationBoardAddReply(@ModelAttribute DonationReply donationReply, HttpServletRequest request) {
		   String userId = (String)request.getSession().getAttribute("userId");
		   donationReply.setDtReplyUserId(userId);
		   int result = service.registerReply(donationReply);
		   if(result > 0) {
			   service.modifyReplyCount(donationReply.getBoardNo());
			   return "success";
		   }else {
			   return"fails";
		   }
	   }
	   
	   // 기부게시판 댓글 리스트 출력
	   @ResponseBody
	   @RequestMapping(value="donationReplyList.do", method=RequestMethod.GET)
	   public void showDonationReplyList(@RequestParam("boardNo") int boardNo, HttpServletResponse response) throws Exception {
		   List<DonationReply> drList = service.printAllReply(boardNo);
		   if(!drList.isEmpty()) {
			   Gson gson = new Gson();
			   gson.toJson(drList, response.getWriter());
		   }else {
			   System.out.println("댓글 데이터 전송 실패");
		   }
	   }
}
