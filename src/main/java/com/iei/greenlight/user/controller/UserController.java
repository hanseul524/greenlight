package com.iei.greenlight.user.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

import com.iei.greenlight.common.UserPagination;
import com.iei.greenlight.user.domain.PageInfo;
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
   
    // 회원 정보 출력
	@RequestMapping(value="myPageInfo.do", method=RequestMethod.GET)
	public String myPageInfo(HttpServletRequest request, Model model, HttpSession session) {
		String userId = (String) session.getAttribute("userId");
		User user = service.printUser(userId);
		if(user != null) {
			model.addAttribute("user", user);
			return "mypage/UserInfo";
		}else {
			model.addAttribute("user", null);
			return "mypage/UserInfo";
		}
	}
	
	// 회원 정보 수정
	@RequestMapping(value="modifyInfo.do", method=RequestMethod.POST)
	public String modifyInfo(@ModelAttribute User user, @RequestParam("post") String post, @RequestParam("addrOne") String addrOne, @RequestParam("addrTwo") String addrTwo, Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		user.setUserAddr(post+"/"+addrOne+"/"+addrTwo);
		try {
			int result = service.modifyUser(user);
			if(result > 0) {
				session.setAttribute("loginUser", user);
				return "redirect:myPageInfo.do";
			}else {
				model.addAttribute("loginUser", null);
				return "mypage/UserInfo";
			}
		}catch(Exception e) {
			model.addAttribute("msg", "회원정보 수정 실패");
			return "common/errorPage";
		}
		
	}
	
	// 회원 탈퇴
	@RequestMapping(value="userDelete.do", method=RequestMethod.GET)
	public String userDelete(@RequestParam("userId") String userId, Model model) {
		
		int result = service.removeUser(userId);
		if(result >0) {
			
			return "redirect:logout.do"; 
		}else {
			model.addAttribute("msg", "회원 탈퇴 실패");
			return "common/errorPage";
		}
	}
	
	// 관리자 페이지 회원 리스트 받아오기
	@RequestMapping(value="userList.do", method=RequestMethod.GET)
	public String UserListView(
			@ModelAttribute User user,
			Model model,
			@RequestParam(value="page", required=false) Integer page) {
		int currentPage = (page != null) ? page : 1;
		int totalCount = service.getListCount();
		PageInfo upi = UserPagination.getpageInfo(currentPage, totalCount);
		List<User> uList = service.showUserList(upi);
		if(!uList.isEmpty()) {
			int point;
			int chargePoint; 
			int sum;
			for(int i=0; i<uList.size(); i++) {
				point = uList.get(i).getPoint();
				chargePoint = uList.get(i).getChargePoint();
				sum = point+chargePoint;
				uList.get(i).setPoint(sum);
			}
			model.addAttribute("uList", uList);
			model.addAttribute("upi", upi);
			return "admin/admin";
		}else {
			model.addAttribute("msg", "회원 리스트 조회 실패");
			return "common/errorPage";
		}
	}
	
	// 관리자 페이지 회원 검색
	@RequestMapping(value="searchUserView.do", method=RequestMethod.GET)
	public String searchUserList(
			@RequestParam("userId") String userId,
			@RequestParam(value="page", required=false) Integer page,
			Model model) {
		
		HashMap<String, Object> hashmap = new HashMap<String, Object>();
		int currentPage = (page != null) ? page : 1;
		int totalCount = service.getSearchListCount(userId);
		PageInfo upi = UserPagination.getpageInfo(currentPage, totalCount);
		hashmap.put("upi", upi);
		hashmap.put("userId", userId);
		List<User> uList = service.printSearchList(hashmap);
		if(!uList.isEmpty()) {
			int point;
			int chargePoint; 
			int sum;
			for(int i=0; i<uList.size(); i++) {
				point = uList.get(i).getPoint();
				chargePoint = uList.get(i).getChargePoint();
				sum = point+chargePoint;
				uList.get(i).setPoint(sum);
			}
			model.addAttribute("uList", uList);
			model.addAttribute("upi", upi);
			model.addAttribute("userId", userId);
			return "admin/adminUserSearchList";
		}else {
			model.addAttribute("uList", null);
			return "admin/adminUserSearchList";
		}
	}
	
	// 관리자 페이지 회원 삭제
	@ResponseBody
	@RequestMapping(value="userDeleteList.do", method=RequestMethod.POST)
	public String deleteUserList(@RequestParam("chkArray[]") List<String> chkboxValues) {
		List<String> uList = new ArrayList<String>();
		for(int i=0; i<chkboxValues.size(); i++) {
			uList.add(chkboxValues.get(i));
		}
		System.out.println(uList.toString());
		int result = service.removeUser(uList);
		if(result > 0) {
			return "success";
		}else {
			return "fail";			
		}
	}
	
}