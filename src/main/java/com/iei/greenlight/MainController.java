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

@Controller
public class MainController {
	
	@Autowired
	private EventService service;
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
		model.addAttribute("event", event);
		System.out.println(cFList);
		if(!wList.isEmpty()) {
			model.addAttribute("wList", wList);
			model.addAttribute("cFList", cFList);
		}else {
			model.addAttribute("wList", null);
			model.addAttribute("cFList", cFList);
		}
		return "common/main";
	}

}
