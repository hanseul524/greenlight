package com.iei.greenlight;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.iei.greenlight.challenge.domain.CFile;
import com.iei.greenlight.challenge.domain.Challenge;
import com.iei.greenlight.challenge.service.ChallengeService;
import com.iei.greenlight.event.domain.Event;
import com.iei.greenlight.event.domain.EventWinner;
import com.iei.greenlight.event.service.EventService;
import com.iei.greenlight.mypage.domain.PointHistory;
import com.iei.greenlight.mypage.service.MyPageService;
import com.iei.greenlight.user.domain.User;

@Controller
public class MainController {
	
	@Autowired
	private EventService service;
	@Autowired
	private MyPageService pservice;
	@Autowired
	private ChallengeService cService;
	
	@RequestMapping(value="/main.do", method=RequestMethod.GET)
	public String mainController(Model model) {
		List<Challenge> cList = cService.printMainChallenge();
		List<CFile> cFList = new ArrayList<CFile>();
		for(int i=0; i<cList.size(); i++) {
			int chNo = cList.get(i).getChNo();
			CFile c = cService.getMainCFileList(chNo);
			cFList.add(c);
		}
		Event event = service.printEvent();
		List<EventWinner> wList = service.printEventWinner();
		
		List<User> user = pservice.printTotalPointMain();
		List<PointHistory> history = pservice.printTotalUseMain();
		// 난수 생성
		double dValue = Math.random();
		int iValue = (int)(dValue * 10)+1;
		
		try {
			if(!user.isEmpty()) {
				model.addAttribute("user", user);
				model.addAttribute("history", history);
				model.addAttribute("iValue", iValue);
				model.addAttribute("cFList", cFList);
				
			}
			if(!wList.isEmpty()) {
				model.addAttribute("cFList", cFList);
				model.addAttribute("event", event);
				model.addAttribute("wList", wList);
			}else {
				model.addAttribute("wList", null);
				model.addAttribute("cFList", cFList);
			}
			
		} catch (Exception e) {
			model.addAttribute("msg", e);
			return "common/errorPage";
		}	
		model.addAttribute("event", event);
		return "common/main";
	}
}	
