package com.iei.greenlight.mypage.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.iei.greenlight.mypage.service.MyPageService;

@Controller
public class MyPageController {
	
	
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
	public String myPageInfo(HttpServletRequest request) {
		
		return "mypage/UserInfo";
	}
}
