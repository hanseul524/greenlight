package com.iei.greenlight.user.controller;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.iei.greenlight.user.domain.User;
import com.iei.greenlight.user.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService service;
	
	@RequestMapping(value="loginView.do", method=RequestMethod.GET)
	public String loginView() {
		return "user/login";
	}
	
	
	@RequestMapping(value="login.do", method=RequestMethod.POST)
	public String loginUser(@ModelAttribute User user, HttpServletRequest request) {
		HttpSession session = request.getSession();
		User userOne = service.loginUser(user);
		if(userOne != null) {
			String userId = userOne.getUserId();
			session.setAttribute("userId", userId);
			System.out.println(userId);
			return "redirect:loginView.do";
		}else {
			return"user/error";
		}
	}
}
