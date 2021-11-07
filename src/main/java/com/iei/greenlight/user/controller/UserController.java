package com.iei.greenlight.user.controller;

import java.sql.Date;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

        System.out.println("수신자 번호 : " + phoneNumber);
        System.out.println("인증번호 : " + numStr);
        service.certifiedPhoneNumber(phoneNumber,numStr);
        return numStr;
    }
   
   // 회원가입
   @RequestMapping(value="joinUser.do", method=RequestMethod.POST)
   public String joinUser(@ModelAttribute User user,@RequestParam("inputAddress") String inputAddress, @RequestParam("inputAddress2") String inputAddress2, @RequestParam("inputAddress3") String inputAddress3) {
      user.setUserAddr(inputAddress + "/" + inputAddress2 + "/" + inputAddress3);
      System.out.println(user.getUserId());
      int result = service.registerUser(user);
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
         System.out.println(userId);
         return "redirect:main.do";
      }else {
         return"user/error";
      }
      
   }
   
}