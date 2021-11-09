package com.iei.greenlight.mypage.controller;

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

import com.iei.greenlight.auction.domain.Auction;
import com.iei.greenlight.mypage.domain.PointHistory;
import com.iei.greenlight.mypage.service.MyPageService;
import com.iei.greenlight.user.domain.User;

@Controller
public class MyPageController {
	
	@Autowired
	private MyPageService service;
	
	// mypage 활동기여도
	@RequestMapping(value="myPage.do", method=RequestMethod.GET)
	public String myPage(HttpServletRequest request) {
		
		return "mypage/MyPage";
	}
	// point 이력 출력
	@RequestMapping(value="myPagePoint.do")
	public String myPagePointHistory(HttpSession session, Model model) {
		String userId = (String)session.getAttribute("userId");
		List<PointHistory> point = service.printPoint(userId);
		System.out.println(point.toString());
		if(point != null) {
			model.addAttribute("point", point);
			return "mypage/PointHistory";
		}else {
			model.addAttribute("msg", "실패");
			return "common/errorPage";
		}
	}
	// 출석체크
	@RequestMapping(value="myPageAdCheck.do")
	public String myPageAdCheck(HttpServletRequest request) {
		
		return "mypage/AdCheck";
	}
	// 회원 정보 출력
	@RequestMapping(value="myPageInfo.do")
	public String myPageInfo(HttpServletRequest request, Model model, HttpSession session) {
		String userId = (String) session.getAttribute("userId");
		User user = service.printUser(userId);
		if(user != null) {
			model.addAttribute("user", user);
			return "mypage/UserInfo";
		}else {
			return "common/errorPage";
		}
	}
	// 회원 정보 수정
	@RequestMapping(value="modifyInfo.do", method=RequestMethod.POST)
	public String modifyInfo(@ModelAttribute User user, @RequestParam("post") String post, @RequestParam("addrOne") String addrOne, @RequestParam("addrTwo") String addrTwo, Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		user.setUserAddr(post+"/"+addrOne+"/"+addrTwo);
		System.out.println(post + addrOne + addrTwo);
		try {
			int result = service.modifyUser(user);
			if(result > 0) {
				session.setAttribute("loginUser", user);
				return "redirect:myPageInfo.do";
			}else {
				model.addAttribute("msg", "회원 정보 수정 실패");
				return "common/errorPage";
			}
		}catch(Exception e) {
			model.addAttribute("msg", "회원정보 수정 실패");
			return "common/errorPage";
		}
		
	}
	// 회원 탈퇴
	@RequestMapping(value="userDelete.do", method=RequestMethod.GET)
	public String userDelete(@RequestParam("userId") String userId, Model model) {
		
		int result = service.removeUser(userId);
		if(result >0) {
			
			return "redirect:logout.do"; 
		}else {
			model.addAttribute("msg", "회원 탈퇴 실패");
			return "common/errorPage";
		}
	}
	
	@RequestMapping(value="myChallenge.do")
	public String myChallenge() {
		
		return "mypage/MyChallenge";
	}
	// 내가 올린 경매
	@RequestMapping(value="myAcution.do")
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
	
	@RequestMapping(value="myBidList.do")
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
