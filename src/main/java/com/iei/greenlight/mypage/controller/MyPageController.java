package com.iei.greenlight.mypage.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
		try {
			if(!user.isEmpty()) {
				model.addAttribute("user", user);
				model.addAttribute("history", history);
				model.addAttribute("iValue", iValue);
				return "mypage/MyPage";
			}else {
				model.addAttribute("user", null);
				model.addAttribute("history", null);
				model.addAttribute("userId", null);
				return "mypage/MyPage";
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
	   @RequestMapping(value="myPageAdCheck.do", method=RequestMethod.GET)
	   public String myPageAdCheck(Model model, HttpSession session) {
	      String userId = (String) session.getAttribute("userId");
	      String arr = null;
	      String lastCheck = null;
	      List<String> arry = new ArrayList<String>();
	      List<AdCheck> ad = service.printAdCheck(userId);
	      Calendar c1 = new GregorianCalendar();
		  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
		  String toDay = sdf.format(c1.getTime()); 
	      for(int i = 0; i < ad.size(); i++) {
	         arr = String.valueOf(ad.get(i).getAdDate());
	         lastCheck = String.valueOf(ad.get(0).getAdDate());
	         arry.add(arr);
	      }
	      try {
	         if(!ad.isEmpty()) {
	        	model.addAttribute("today", toDay);
	        	model.addAttribute("lastCheck", lastCheck);
	            model.addAttribute("ad", ad);
	            model.addAttribute("arry", arry);
	            model.addAttribute("userId", userId);
	            return "mypage/AdCheck";
	         }else {
	            model.addAttribute("ad", null);
	            model.addAttribute("consecutive", 0);
	            model.addAttribute("userId", null);
	            return "mypage/AdCheck";
	         }
	      } catch (Exception e) {
	         model.addAttribute("msg", e);
	         return "common/errorPage";
	      }
	   }
	   
	@RequestMapping(value="adChecking.do", method=RequestMethod.POST)
	   public String myPageAdChecking(Model model, @RequestParam("adDate") String adDate, @RequestParam(value="consecutive", required = false) int consecutive, HttpSession session) {
		   String id = (String) session.getAttribute("userId");
		   Calendar c1 = new GregorianCalendar();
	       c1.add(Calendar.DATE, -1); // 오늘날짜로부터 -1
	       int pulsConsecutive = consecutive+1;
	       int result = 0;
	       HashMap<String, Object> hashMap = new HashMap<String, Object>();
		   SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // 날짜 포맷 
		   String yesterDay = sdf.format(c1.getTime()); // String으로 저장
	       if(yesterDay.equals(adDate)) {
	    	   if(pulsConsecutive%7 == 0) {
	    		   hashMap.put("puls", pulsConsecutive);
	    		   hashMap.put("userId", id);
	    		   result = service.addContinuityAdCheck(hashMap);
	    	   }else {
	    		   hashMap.put("puls", pulsConsecutive);
	    		   hashMap.put("userId", id);
	    		   result = service.addAdCheck(hashMap);
	    	   }
	       }else {
	    	   result = service.addNonConAdCheck(id);
	       }
		   
		   try {
			   if (result > 0) {
				   return "redirect:myPageAdCheck.do";
			   }else {
				   return "redirect:myPageAdCheck.do";
			   }
			} catch (Exception e) {
				model.addAttribute("msg", e);
				return "common/errorPage";
			}
	   }
	
	
	
}
