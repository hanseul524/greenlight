package com.iei.greenlight.auction.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.iei.greenlight.auction.domain.AdminPageInfo;
import com.iei.greenlight.auction.domain.Auction;
import com.iei.greenlight.auction.domain.AuctionHistory;
import com.iei.greenlight.auction.domain.AuctionImage;
import com.iei.greenlight.auction.domain.AuctionUser;
import com.iei.greenlight.auction.domain.PageInfo;
import com.iei.greenlight.auction.service.AuctionService;
import com.iei.greenlight.common.AdminAuctionPagination;
import com.iei.greenlight.common.AuctionPagination;
import com.iei.greenlight.mypage.service.MyPageService;
import com.iei.greenlight.user.domain.User;
import com.iei.greenlight.user.service.UserService;

@Controller
public class AuctionController {
	
	@Autowired
	private AuctionService service;
	@Autowired
	private MyPageService myPageService;
	
	@RequestMapping(value="admin.do")
	public String asdfasdf() {
		
		return "admin/adminCh";
	}
	 
	// 관리자 재고 페이지 이동
	@RequestMapping(value="adminAuctionView.do")
	public String adminAuctionPageView(HttpServletRequest request, Model model, @RequestParam(value="page", required = false) Integer page) {
		
		int currentPage = (page != null) ? page : 1;
		int totalCount = service.getAdminListCount();
		AdminPageInfo pi = AdminAuctionPagination.getPageInfo(currentPage, totalCount);
		List<Auction> aList = service.printAuctionAllList(pi);
		if(!aList.isEmpty()) {
			model.addAttribute("aList", aList);
			return "admin/adminAuction";
		}else {
			model.addAttribute("aList", null);
			return "admin/adminAuction";
		}
		
	}
	
	// 리스트 페이지 이동
	@RequestMapping(value="auctionListView.do")
	public String auctionListView(HttpServletRequest request, Model model, @RequestParam(value="page", required = false) Integer page) {
			System.out.println(page);
			int currentPage = (page != null) ? page : 1;
			System.out.println("page : " + page);
			int totalCount = service.getListCount();
			System.out.println("totalCount" + totalCount);
			PageInfo pi = AuctionPagination.getPageInfo(currentPage, totalCount);
			System.out.println("ControllerStartNavi" + pi.getStartNavi());
			List<AuctionHistory> aList = service.printAllList(pi);
			if(!aList.isEmpty()) {
				model.addAttribute("aList", aList);
				return "auction/auctionList";
			}else {
				model.addAttribute("aList", null);
				return "auction/auctionList";
			}
	}
	
	// 관리자 경매 승인
	@RequestMapping(value="registAuctionHistory.do", method=RequestMethod.POST)
	public String registAuctionHistory(Model model, @RequestParam("auctionNo") int[] auctionNo) {
		
		List<Auction> aList = new ArrayList<Auction>();
		List<AuctionHistory> hList = new ArrayList<AuctionHistory>();
		SimpleDateFormat format1 = new SimpleDateFormat ("yyyy-MM-dd-HH-mm-ss");
		Date time = new Date();
		String time1 = format1.format(time);
		
		for(int a : auctionNo) {
			System.out.println("auctionNo : " + a);
		}
		
		for(int i = 0; i < auctionNo.length; i++) {
			Auction auction = service.printAuctionOneByNo(auctionNo[i]);
			AuctionHistory auctionHistory = new AuctionHistory(auction.getAuctionNo(), auction.getUserId(), time1, auction.getAuctionTitle(), auction.getAuctionTime(), auction.getAuctionPrice());
			hList.add(auctionHistory);
		}
		
		int result = service.registerAuctionHistory(hList);
		System.out.println("auctionHistory : " + result);
		if(result > 0) {
			int remove = service.removeAuction(auctionNo);
		}
		return "redirect:adminAuctionView.do";
	}
	
	// 경매 디테일 페이지
	@RequestMapping(value="auctionDetail.do")
	public String auctionDetailView(@RequestParam("auctionNo") int auctionNo, Model model, HttpServletRequest request) {
		
		try {
			AuctionUser auctionUser = service.printAuctionUser(auctionNo);
			User user = myPageService.printUser((String)request.getSession().getAttribute("userId"));
			AuctionHistory auctionHistory = service.printAuctionHistoryOneByNo(auctionNo);
			if(auctionHistory != null) {
				List<AuctionImage> imageList = service.printAuctionImageOneByNo(auctionNo);
				model.addAttribute("auctionUser", auctionUser);
				model.addAttribute("user", user);
				model.addAttribute("auctionHistory", auctionHistory);
				model.addAttribute("auctionImage", imageList);
				return "auction/auctionDetail";
			}else {
				model.addAttribute("msg", "디테일 조회 실패");
				return "common/errorPage";
			}
		}catch(Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.toString());
			return "common/errorPage";
		}
	}
	
	// 경매 신청글 페이지 이동
	@RequestMapping(value="auctionWrite.do")
	public String auctionWriteView() {
		
		return "auction/auctionWrite";
		
	}

	// 경매 신청
	@RequestMapping(value="auctionApply.do", method=RequestMethod.POST)
	public String auctionApply(@ModelAttribute Auction auction, HttpServletRequest request, Model model, @RequestParam("uploadFiles") MultipartFile[] uploadFiles) {
		
		auction.setUserId((String)request.getSession().getAttribute("userId")); // session값에서 아이디 가지고 오기
		List<AuctionImage> aList = null;
		
		try {
			SimpleDateFormat format1 = new SimpleDateFormat ("yyyy-MM-dd-HH-mm-ss");
			Date time = new Date();
			String time1 = format1.format(time);
			auction.setVarRegDate(time1);
			int result = service.registerAuction(auction); // insert 됐을 시 auctionNo 을 가져와야되
			if(result > 0) {
				aList = new ArrayList<AuctionImage>();
				for(MultipartFile uploadFile : uploadFiles) {
					if(!uploadFile.getOriginalFilename().equals("")) {
						AuctionImage auctionImage = saveFile(uploadFile, request);
						auctionImage.setAuctionNo(auction.getAuctionNo()); // selectKey를 이용한 primaryKey 값 가져오기
						auctionImage.setUserId((String)request.getSession().getAttribute("userId")); // 임의 아이디
						auctionImage.setFileSize(uploadFile.getSize());
						auctionImage.setFileMain("N");
						aList.add(auctionImage);
					}
				}
				aList.get(0).setFileMain("Y"); // 첫번째 사진 mainImage 등록
				int image = service.registerAuctionImage(aList);
				return "redirect:auctionListView.do";
			}else {
				model.addAttribute("msg", "경매 신청글 실패");
				return "common/errorPage";
			}
		}catch(Exception e) {
			model.addAttribute("msg", e.toString());
			return "common/errorPage";
		}
	}
	
	// 경매 신청 파일 저장
	public AuctionImage saveFile(MultipartFile uploadFile, HttpServletRequest request) {
		
		String root = request.getSession().getServletContext().getRealPath("resources");
		String savePath = root + "\\auctionImage"; // 경로 생성
		File folder= new File(savePath);
		if(!folder.exists()) {
			folder.mkdir(); // 폴더생성
		}
		
		String filePath = folder + "\\" + uploadFile.getOriginalFilename(); // 파일 절대 경로
		String fileName = uploadFile.getOriginalFilename();
		
		try {
			uploadFile.transferTo(new File(filePath)); // 파일 업로드
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		AuctionImage auctionImage = new AuctionImage(fileName, filePath);
		return auctionImage;
	}
	
	@RequestMapping(value="insertAuctionUser.do")
	public String insertAuctionUser(@ModelAttribute AuctionUser auctionUser) {
		System.out.println(auctionUser.toString());
		int result = service.registerAuctionUser(auctionUser);
		
		return "redirect:auctionDetail.do?auctionNo="+auctionUser.getAuctionNo();
	}
	
	@RequestMapping(value="insertAuctionSuccessFul.do")
	public String insertAuctionSuccessFul(@RequestParam("auctionNo") int auctionNo, @RequestParam("userId") String userId) {
		
		//int result = service.modifyAuctionHistory(auctionNo);
		
		System.out.println(auctionNo + ", " + userId);
		
		return "";
	}
	
	// 내가 올린 경매
	   @RequestMapping(value="myAcution.do", method=RequestMethod.GET)
	   public String myAuction(Model model, HttpSession session) {
	      try {
	         String userId = (String)session.getAttribute("userId");
	         System.out.println("경매 리스트 유저아이디 : " + userId);
	         List<Auction> aList = service.printAllList(userId);
	         if(!aList.isEmpty()) {
	            model.addAttribute("aList", aList);
	            return "mypage/MyAuction";
	         }else {
	            model.addAttribute("aList", null);
	            return "common/errorPage";
	         }
	      }catch(Exception e) {
	         e.printStackTrace();
	         model.addAttribute("msg", e.toString());
	         return "common/errorPage";
	      }
	   }
	   // 내가 입찰한 경매
	   @RequestMapping(value="myBidList.do", method=RequestMethod.GET)
	   public String myBidList(Model model, HttpSession session) {
	      
	      String userId = (String) session.getAttribute("userId");
	      List<Auction> aList = service.printList(userId);
	      if(aList != null) {
	         model.addAttribute("aList", aList);
	         return "mypage/MyBidList";
	      }else {
	         model.addAttribute("aList", null);
	         return "common/errorPage";
	      }
	   }

}
