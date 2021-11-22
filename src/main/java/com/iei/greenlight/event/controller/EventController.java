package com.iei.greenlight.event.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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

import com.iei.greenlight.common.EventPagination;
import com.iei.greenlight.common.OfflineShopPagination;
import com.iei.greenlight.event.domain.Event;
import com.iei.greenlight.event.domain.EventAnswer;
import com.iei.greenlight.event.domain.EventPageInfo;
import com.iei.greenlight.event.domain.EventWinner;
import com.iei.greenlight.event.service.EventService;
import com.iei.greenlight.mypage.service.MyPageService;
import com.iei.greenlight.shop.domain.OfflinePageInfo;
import com.iei.greenlight.user.service.UserService;

@Controller
public class EventController {
	
	@Autowired
	private EventService service;
	@Autowired
	private UserService userService;
	@Autowired
	private MyPageService mypageService;
	
	// 관리자 이벤트 등록 페이지 이동
	@RequestMapping(value="adminEventPage.do")
	public String adminEventView(Model model, @RequestParam(value="page", required=false) Integer page) {
		
		int currentPage = (page != null) ? page : 1;
		int eventAnswerCount = service.getEventAnswerListCount();
		int eventWinnerCount = service.getEventWinnerListCount();
		EventPageInfo pi = EventPagination.getPagination(currentPage, eventAnswerCount);
		EventPageInfo api = EventPagination.getPagination(currentPage, eventWinnerCount);
		List<EventAnswer> aList = service.printEventAnswerList(pi);
		List<EventWinner> wList = service.printEventWinnerList(api);
		
		if(!aList.isEmpty() && wList.isEmpty()) {
			model.addAttribute("pi", pi);
			model.addAttribute("api", api);
			model.addAttribute("aList", aList);
			model.addAttribute("wList", null);
		}else if(aList.isEmpty() && !wList.isEmpty()) {
			model.addAttribute("pi", pi);
			model.addAttribute("api", api);
			model.addAttribute("aList", null);
			model.addAttribute("wList", wList);
		}else if(!aList.isEmpty() && !wList.isEmpty()) {
			model.addAttribute("pi", pi);
			model.addAttribute("api", api);
			model.addAttribute("aList", aList);
			model.addAttribute("wList", wList);
		}else if(aList.isEmpty() && wList.isEmpty()){
			model.addAttribute("pi", pi);
			model.addAttribute("api", api);
			model.addAttribute("aList", null);
			model.addAttribute("wList", null);
		}
		return "admin/adminEvent";
	}
	
	// 이벤트 등록 페이지 이동
	@RequestMapping(value="adminEventWriteView.do")
	public String adminRegisterEventView() {
		return "admin/eventPopup";
	}
	
	// 이벤트 검색 페이지 이동
	@ResponseBody
	@RequestMapping(value="eventSearchView.do")
	public String eventSearchView(@RequestParam("userId") String userId) {
		
		int result = service.printEventCheckUserId(userId);
		if(result > 0) {
			return "success";
		}else {
			return "fail";
		}
	}
	
	
	// 이벤트 등록
	@ResponseBody
	@RequestMapping(value="registerEvent.do", method=RequestMethod.POST)
	public String adminRegisterEvent(Model model, @ModelAttribute Event event) {
		
		try {
			int removeEvent = service.removeEvent();
			//int removeEventAnswer = service.removeEventAnswer();
			//int removeEventWinning = service.removeEventWinner();
			SimpleDateFormat format = new SimpleDateFormat ("yyyy-MM-dd-HH-mm-ss");
			Calendar cal = Calendar.getInstance();
			Date time = new Date();
			cal.setTime(time);
			cal.add(Calendar.DATE, 5);
			event.setEventStart(format.format(time));
			event.setEventEnd(format.format(cal.getTime()).substring(0, 11) + "20-00-00");
			event.setEventPoint(100);
			System.out.println(event.toString());
			int result = service.registerEvent(event);
			if(result > 0) {
				return "success";
			}else {
				return "fail";
			}
		}catch(Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.toString());
			return "common/errorPage";
		}
	}
	
	// 이벤트 종료 시 당첨자 추첨
	@RequestMapping(value="eventRaffle.do")
	public String eventEnd(Model model) {
		
		List<EventAnswer> eList = service.printEventAnswerList(); // rowNum
		List<EventWinner> wList = new ArrayList<EventWinner>();
		int eventNo = eList.get(0).getEventNo();
		
		int count = (eList.size() > 10) ? (int)((int)Math.round(eList.size()/10.0) * 10 * 0.1) : 1; // 맞힌 사람 중 10% 인원수
		
		
		int [] a = new int[count];
		
		// 중복없는 랜덤함수 
		for (int i = 0; i < count; i++) {
			a[i] = (int) (Math.random() * eList.size()) + 1; // 중복이 되면 안됨
			for (int j = 0; j < i; j++) {
				if (a[i] == a[j]) {
					i--;
					break;
				}
			}
		}
		
		// 이벤트 당첨자 리스트 추가
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < eList.size(); j++) {
				if(a[i] == eList.get(j).getRowNum()) {
					EventWinner eventWinner = new EventWinner(eventNo, eList.get(j).getUserId());
					wList.add(eventWinner);
				}
			}
		}
		
		
		service.removeEventAnswer();
		int result = service.registerEventWinner(wList); // 당첨자 등록
		
		return "redirect:adminEventPage.do";
	}
	
	// 이벤트 정답시 포인트 지급 및 포인트 히스토리
	@ResponseBody
	@RequestMapping(value="eventUserApply.do", method=RequestMethod.POST)
	public String insertEventAnswerPoint(HttpServletRequest request, int eventNo) {
		
		HashMap<String, Object> hashmap = new HashMap<String, Object>();
		String userId = (String)request.getSession().getAttribute("userId");
		hashmap.put("userId", userId);
		hashmap.put("eventNo", eventNo);
		int result = service.registerEventAnswer(hashmap);
		int pointAnswer = userService.modifyEventAnswerPoint(userId); // 포인트 지급
		int pointHistory = mypageService.registerEventAnswerPointHistory(userId); // 포인트 히스토리 추가
		
		if(pointHistory > 0) {
			return "success";
		}else {
			return "false";
		}
	}
	
	
	// 이벤트 당첨 포인트 지급 및 포인트 히스토리
	@RequestMapping(value="eventWinnerPayments.do")
	public String insertEventWinningPoint(Model model) {
		
		try {
			List<EventWinner> wList = service.printEventWinnerList();
			String [] userId = new String[wList.size()];
			for(int i = 0; i < userId.length; i++) {
				userId[i] = wList.get(i).getUserId();
			}
			int pointUpdate = service.modifyEventWinner(userId);
			int pointWinner = userService.modifyEventWinnerPoint(userId);
			int pointHistory = mypageService.registerEventWinnerPointHistory(wList);
		}catch(Exception e){
			e.printStackTrace();
			model.addAttribute("msg", e.toString());
			return "common/errorPage";
		}
		return "redirect:adminEventPage.do";
	}
	
	@ResponseBody
	@RequestMapping(value="eventUserIdCheck.do", method=RequestMethod.POST)
	public String eventUserCheck(HttpServletRequest request) {
		
		String userId = (String)request.getSession().getAttribute("userId");
		int check = service.printEventAnswerUserCheck(userId);
		if(check == 1) {
			return "false";
		}else {
			return "success";
		}
	}
	
}
