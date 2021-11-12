package com.iei.greenlight.user.controller;

import java.sql.Date;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iei.greenlight.user.domain.User;
import com.iei.greenlight.user.service.UserService;

@Controller
public class UserController {
   
   @Autowired
   private UserService service;
   
   
   // 로그인 페이지 이동
   @RequestMapping(value="loginView.do", method=RequestMethod.GET)
   public String loginView() {
      return "user/login";
   }
   
   // 회원가입 페이지 이동
   @RequestMapping(value="enrollView.do", method=RequestMethod.GET)
   public String enrollView(){
      return "user/enroll";
   }
   
   // 소셜아이디 회원가입 페이지 이동
   @RequestMapping(value="socialEnrollView.do", method=RequestMethod.GET)
   public String socialEnrollView (@RequestParam("socialId") String socialId, @RequestParam("userEmail") String userEmail, Model model) {
	   model.addAttribute("socialId", socialId);
	   model.addAttribute("userEmail", userEmail);
	   return "user/socialEnroll";
   }
   
   // 아이디 중복 확인
   @ResponseBody
   @RequestMapping(value="checkDupId.do", method=RequestMethod.POST)
   public String idDuplicateCheck(@RequestParam("userId") String userId) {
      System.out.println(userId);
      int result = service.checkIdDup(userId);
      return String.valueOf(result);
   }
   
   
   // 회원가입 본인인증 문자 발송
   @ResponseBody
   @RequestMapping(value="sendSMS.do", method=RequestMethod.GET)
   public String sendSMS(@RequestParam("phoneNumber") String phoneNumber) {
        Random rand = new Random();
        String numStr = "";
        for(int i=0; i<4; i++) {
            String ran = Integer.toString(rand.nextInt(10));
            numStr+=ran;
        }
        service.certifiedPhoneNumber(phoneNumber,numStr);
        return numStr;
    }
   
   // 회원가입
   @RequestMapping(value="joinUser.do", method=RequestMethod.POST)
   public String joinUser(@ModelAttribute User user,@RequestParam("inputAddress") String inputAddress, @RequestParam("inputAddress2") String inputAddress2, @RequestParam("inputAddress3") String inputAddress3) {
      user.setUserAddr(inputAddress + "/" + inputAddress2 + "/" + inputAddress3);
      int result = service.registerUser(user);
      if(result > 0) {
         return "redirect:loginView.do";
      }else {
         return "user/error";
      }
      
   }
   
   // 소셜 회원가입
   @RequestMapping(value="socialJoin.do", method=RequestMethod.POST)
   public String socialJoin(@ModelAttribute User user, @RequestParam("inputAddress") String inputAddress, @RequestParam("inputAddress2") String inputAddress2, @RequestParam("inputAddress3") String inputAddress3) {
	   user.setUserAddr(inputAddress + "/" + inputAddress2 + "/" + inputAddress3);
	   int result = service.socialRegisterUser(user);
	   if(result > 0) {
		   return "redirect:loginView.do";
	   }else {
		   return "user/error";
	   }
   }
   
   // 로그인
   @RequestMapping(value="login.do", method=RequestMethod.POST)
   public String loginUser(@ModelAttribute User user, HttpServletRequest request) {
      HttpSession session = request.getSession();
      User userOne = service.loginUser(user);
      if(userOne != null) {
         String userId = userOne.getUserId();
         session.setAttribute("userId", userId);
         return "redirect:main.do";
      }else {
         return"user/error";
      }
      
   }
   
   // 로그아웃
   @RequestMapping(value="logout.do", method=RequestMethod.GET)
   public String logoutUser(HttpServletRequest request) {
	   HttpSession session = request.getSession();
	   if(session != null) {
			session.invalidate();
			return"redirect:main.do";
		}else {
			return"user/error";
		}
   }
   
   
   // 소셜 아이디 체크
   @ResponseBody
   @RequestMapping(value="checkSocialId.do", method=RequestMethod.POST)
   public String checkSocialId(@RequestParam("userEmail") String userEmail, @RequestParam("socialId") String socialId) {
	   User userOne = new User();
	   userOne.setUserEmail(userEmail);
	   userOne.setSocialId(socialId);
	   int result = service.checkSocialId(userOne);
	   if(result > 0) {
		   return String.valueOf(result);
	   }else {
		   return String.valueOf(result);
	   }
   }
   
   // 소셜 아이디 로그인
   @RequestMapping(value="socialIdLogin.do", method=RequestMethod.GET)
   public String socialIdLogin(@RequestParam("socialId") String socialId, HttpServletRequest request) {
	   String usersocialId = String.valueOf(socialId);
	   HttpSession session = request.getSession();
	   String userId = service.socialIdLogin(usersocialId);
	  if(userId != null) {
		  session.setAttribute("userId", userId);
		  return "redirect:/main.do";
	  }else {
		  return"user/error";
	  }
   }
   
   
   // 아이디 찾기 체크
   @ResponseBody
   @RequestMapping(value="checkId.do", method=RequestMethod.POST)
   public String checkUserId(@RequestParam("userEmail") String userEmail, @RequestParam("userName") String userName) {
	   User userOne = new User();
	   userOne.setUserEmail(userEmail);
	   userOne.setUserName(userName);
	   String subject = "";  	// 메일 제목
	   String content = "";		// 메일 내용
	   String sender = "";		// 보낸이
	   int authCode = 0;		// 난수
	   String authCodes = "";	// 인증코드
	   int result = service.checkUserId(userOne);
	   if(result > 0) {
		   for(int i=0; i<6; i++) {
			   authCode = (int)(Math.random()*9+1);
			   authCodes += Integer.toString(authCode);
		   }
		   subject = "안녕하세요 Green Light 입니다. 아이디 찾기 인증번호 입니다.";
		   content = "이이디 찾기 인증코드는 " + authCodes + " 입니다.";
		   sender = "greensmt01@gmail.com";
		   service.sendMail(subject, content, sender, userEmail);
		   return authCodes;
	   }else {
		   return String.valueOf(result);
	   }
   }
   
   // 아이디 찾기
   @ResponseBody
   @RequestMapping(value="findId.do", method=RequestMethod.POST)
   public String userId(@RequestParam("userEmail") String userEmail, @RequestParam("userName") String userName) {
	   User userOne = new User();
	   userOne.setUserEmail(userEmail);
	   userOne.setUserName(userName);
	   String userId = service.showUserId(userOne);
	   return userId;
   }
   
   // 비밀번호 찾기 체크
   @ResponseBody
   @RequestMapping(value="checkUserPwd.do", method=RequestMethod.POST)
   public String checkUserPwd(@RequestParam("userEmail") String userEmail, @RequestParam("userId") String userId) {
	   User userOne = new User();
	   userOne.setUserId(userId);
	   userOne.setUserEmail(userEmail);
	   String subject = "";  	// 메일 제목
	   String content = "";		// 메일 내용
	   String sender = "";		// 보낸이
	   int authCode = 0;		// 난수
	   String authCodes = "";	// 인증코드
	   int result = service.checkUserPwd(userOne);
	   if(result > 0) {
		   for(int i=0; i<6; i++) {
			   authCode = (int)(Math.random()*9+1);
			   authCodes += Integer.toString(authCode);
		   }
		   subject = "안녕하세요 Green Light 입니다. 비밀번호 찾기 인증번호 입니다.";
		   content = "비밀번호 찾기 인증코드는 " + authCodes + " 입니다.";
		   sender = "greensmt01@gmail.com";
		   service.sendMail(subject, content, sender, userEmail);
		   return authCodes;
	   }else {
		   return String.valueOf(result);
	   }
   }
   
   // 비밀번호 변경
   @ResponseBody
   @RequestMapping(value="userPwdUpdate.do", method=RequestMethod.POST)
   public String userPwdUpdate(@RequestParam("userId") String userId, @RequestParam("userPwd") String userPwd) {
	   User userOne = new User();
	   userOne.setUserId(userId);
	   userOne.setUserPwd(userPwd);
	   int result = service.modifyUserPwd(userOne);
	   return String.valueOf(result);
   }
}