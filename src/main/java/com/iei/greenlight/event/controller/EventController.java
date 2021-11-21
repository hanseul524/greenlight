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

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.iei.greenlight.event.domain.Event;
import com.iei.greenlight.event.domain.EventAnswer;
import com.iei.greenlight.event.domain.EventWinner;
import com.iei.greenlight.event.service.EventService;
import com.iei.greenlight.mypage.service.MyPageService;
import com.iei.greenlight.user.service.UserService;

public class EventController {
	
	private EventService service;
	private UserService userService;
	private MyPageService mypageService;
	
	// 이벤트 등록
	public String adminRegisterEvent(Model model, @ModelAttribute Event event) {
		
		try {
			int removeEvent = service.removeEvent();
			int removeEventAnswer = service.removeEventAnswer();
			int removeEventWinning = service.removeEventWinner();
			SimpleDateFormat format = new SimpleDateFormat ("yyyy-MM-dd-HH-mm-ss");
			Calendar cal = Calendar.getInstance();
			Date time = new Date();
			cal.setTime(time);
			cal.add(Calendar.DATE, 5);
			event.setEventStart(format.format(time));
			event.setEventEnd(format.format(cal.getTime()).substring(0, 11) + "20-00-00");
			event.setEventPoint(100);
			int result = service.registerEvent(event);
		}catch(Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.toString());
			return "common/errorPage";
		}
		
		return "";
	}
	
	// 이벤트 종료 시 당첨자 추첨
	public void eventEnd(int eventNo, Model model, HttpServletRequest request) {
		
		List<EventAnswer> eList = service.printEventAnswerList(); // rowNum
		List<EventWinner> wList = new ArrayList<EventWinner>();
		
		int count = (eList.size() > 10) ? (int)((int)Math.round(eList.size()/10.0) * 10 * 0.1) : 1; // 맞힌 사람 중 10% 인원수
		
		int [] a = new int[count];
		
		// 중복없는 랜덤함수 
		for (int i = 0; i < count; i++) {
			a[i] = (int) Math.random() * eList.size() + 1; // 중복이 되면 안됨
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
		
		int result = service.registerEventWinner(wList); // 당첨자 등록
	}
	
	// 이벤트 정답시 포인트 지급 및 포인트 히스토리
	public void insertEventAnswerPoint(HttpServletRequest request, int eventNo) {
		
		HashMap<String, Object> hashmap = new HashMap<String, Object>();
		String userId = (String)request.getSession().getAttribute("userId");
		hashmap.put("userId", userId);
		hashmap.put("eventNo", eventNo);
		int result = service.registerEventAnswer(hashmap);
		int pointAnswer = userService.modifyEventAnswerPoint(userId); // 포인트 지급
		int pointHistory = mypageService.registerEventAnswerPointHistory(userId); // 포인트 히스토리 추가
		
	}
	
	
	// 이벤트 당첨 포인트 지급 및 포인트 히스토리
	public void insertEventWinningPoint() {
		
		HashMap<String, Object> hashmap = new HashMap<String, Object>();
		List<EventWinner> wList = service.printEventWinnerList();
		int pointWinner = userService.modifyEventWinnerPoint(wList);
		int pointHistory = mypageService.registerEventWinnerPointHistory(wList);
		
	}
}
