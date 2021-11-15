package com.iei.greenlight.mypage.controller;

import java.util.ArrayList;
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

import com.iei.greenlight.challenge.domain.Challenge;
import com.iei.greenlight.mypage.common.Pagination;
import com.iei.greenlight.mypage.domain.AdCheck;
import com.iei.greenlight.mypage.domain.PageInfo;
import com.iei.greenlight.mypage.domain.PointHistory;
import com.iei.greenlight.mypage.service.MyPageService;
import com.iei.greenlight.user.domain.User;

@Controller
public class MyPageController {
	
	@Autowired
	private MyPageService service;
	
	// mypage 활동기여도
	@RequestMapping(value="myPage.do", method=RequestMethod.GET)
	public String myPage(HttpSession session, Model model) {
		String userId = (String)session.getAttribute("userId");
		List<User> user = service.printTotalPoint(userId);
		List<PointHistory> history = service.printTotalUse(userId);
		// 난수 생성
		double dValue = Math.random();
		int iValue = (int)(dValue * 10)+1;
		System.out.println(iValue);
		try {
			if(!user.isEmpty()) {
				model.addAttribute("user", user);
				model.addAttribute("history", history);
				model.addAttribute("iValue", iValue);
				return "mypage/MyPage";
			}else {
				model.addAttribute("msg", "실패");
				return "common/errorPage";
			}
		} catch (Exception e) {
			model.addAttribute("msg", e);
			return "common/errorPage";
		}
	}
	// point 이력 출력
	@RequestMapping(value="myPagePoint.do", method=RequestMethod.GET)
	public String myPagePointHistory(HttpSession session, Model model, @RequestParam(value="page", required=false) Integer page) {
		String userId = (String)session.getAttribute("userId");
		int currentPage = (page != null) ? page : 1;
		int totalCount = service.getListCount(userId);
		PageInfo pi = Pagination.getPageInfo(currentPage, totalCount);
		HashMap<String, Object> hashmap = new HashMap<String, Object>();
		hashmap.put("pi", pi);
		hashmap.put("userId", userId);
		List<PointHistory> point = service.printPoint(hashmap);
		try {
			if(!point.isEmpty()) {
				model.addAttribute("point", point);
				model.addAttribute("pi", pi);
				return "mypage/PointHistory";
			}else {
				model.addAttribute("point", null);
				model.addAttribute("pi", pi);
				return "mypage/PointHistory";
			}
		} catch (Exception e) {
			model.addAttribute("msg", e);
			return "common/errorPage";
		}
	}
	// 출석체크
	@RequestMapping(value="myPageAdCheck.do")
	public String myPageAdCheck(HttpServletRequest request) {
		
		return "mypage/AdCheck";
	}
	
	// 출석체크
	   @RequestMapping(value="myPageAdCheck.do", method=RequestMethod.GET)
	   public String myPageAdCheck(Model model, HttpSession session) {
	      String userId = (String) session.getAttribute("userId");
	      String arr = null;
	      List<String> arry = new ArrayList<String>();
	      List<AdCheck> ad = service.printAdCheck(userId);
	      System.out.println(ad.toString());
	      for(int i = 0; i < ad.size(); i++) {
	         arr = String.valueOf(ad.get(i).getAdDate());
	         System.out.println(i);
	         arry.add(arr);
	      }
	      try {
	         if(!ad.isEmpty()) {
	            model.addAttribute("ad", ad);
	            model.addAttribute("arry", arry);
	            return "mypage/AdCheck";
	         }else {
	            model.addAttribute("ad", null);
	            return "mypage/AdCheck";
	         }
	      } catch (Exception e) {
	         model.addAttribute("msg", e);
	         return "common/errorPage";
	      }
	   }
	
	
	
}
