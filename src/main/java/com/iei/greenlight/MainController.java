package com.iei.greenlight;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.iei.greenlight.event.domain.Event;
import com.iei.greenlight.event.domain.EventWinner;
import com.iei.greenlight.event.service.EventService;

@Controller
public class MainController {
	
	@Autowired
	private EventService service;
	
	@RequestMapping(value="/main.do", method=RequestMethod.GET)
	public String mainController(Model model) {
		
		Event event = service.printEvent();
		List<EventWinner> wList = service.printEventWinner();
		model.addAttribute("event", event);
		if(!wList.isEmpty()) {
			model.addAttribute("wList", wList);
		}else {
			model.addAttribute("wList", null);
		}
		return "common/main";
		
	}

}
