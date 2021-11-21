package com.iei.greenlight.event.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.iei.greenlight.event.domain.Event;
import com.iei.greenlight.event.service.EventService;

public class EventController {
	
	private EventService service;
	
	// 이벤트 등록
	public String adminRegisterEvent(Model model, @ModelAttribute Event event) {
		
		try {
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
	
	// 이벤트 종료
	public String eventEnd() {
		
		
		
		return "";
	}
	
	// 이벤트 정답시 포인트 지급 및 포인트 히스토리
	
	
	
	// 
}
