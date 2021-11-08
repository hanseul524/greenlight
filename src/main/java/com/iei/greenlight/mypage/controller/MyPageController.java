package com.iei.greenlight.mypage.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.iei.greenlight.auction.domain.Auction;
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
	
	@RequestMapping(value="myPagePoint.do")
	public String myPagePointHistory(HttpServletRequest request) {
		
		return "mypage/PointHistory";
	}
	
	@RequestMapping(value="myPageAdCheck.do")
	public String myPageAdCheck(HttpServletRequest request) {
		
		return "mypage/AdCheck";
	}
	
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
	
	@RequestMapping(value="myChallenge.do")
	public String myChallenge() {
		
		return "mypage/MyChallenge";
	}
	
	@RequestMapping(value="myAcution.do")
	public String myAcution(HttpServletRequest request, Model model, HttpSession session) {
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
}
