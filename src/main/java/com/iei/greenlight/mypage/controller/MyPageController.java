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
	@RequestMapping(value="myPagePoint.do", method=RequestMethod.GET)
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
	
	
	
	@RequestMapping(value="myChallenge.do")
	public String myChallenge() {
		
		return "mypage/MyChallenge";
	}
}
