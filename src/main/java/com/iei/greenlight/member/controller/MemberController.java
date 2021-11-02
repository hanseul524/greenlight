package com.iei.greenlight.member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.iei.greenlight.member.domain.Member;
import com.iei.greenlight.member.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService service;
	
	@RequestMapping(value="list.do", method=RequestMethod.GET)
	public String printAllList(Model model) {
		
		List<Member> mList = service.printAllList();
		try {
			if(!mList.isEmpty()) {
				model.addAttribute("mList", mList);
				return "member/member"; 
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.toString());
		}
		
		return "";
	}

}
