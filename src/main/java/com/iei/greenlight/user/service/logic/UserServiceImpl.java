package com.iei.greenlight.user.service.logic;

import java.util.HashMap;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.iei.greenlight.user.domain.User;
import com.iei.greenlight.user.service.UserService;
import com.iei.greenlight.user.store.UserStore;

import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserStore store;
	@Autowired
	private JavaMailSenderImpl mailSender;
	
	// 로그인
	@Override
	public User loginUser(User user) {
		User userOne = store.loginUser(user);
		return userOne;
	}

	// 휴대폰 인증
	@Override
	public void certifiedPhoneNumber(String phoneNumber, String numStr) {
		 String api_key = "NCSONNV2NIS96BTQ";
	        String api_secret = "UX41HUMQS2AVNJEZCDJFQUNCWGIFVUNR";
	        Message coolsms = new Message(api_key, api_secret);

	        // 4 params(to, from, type, text) are mandatory. must be filled
	        HashMap<String, String> params = new HashMap<String, String>();
	        params.put("to", phoneNumber);    
	        params.put("from", "01092809673");    
	        params.put("type", "SMS");
	        params.put("text", "휴대폰인증 메시지 : 인증번호는" + "["+numStr+"]" + "입니다.");
	        params.put("app_version", "test app 1.2"); // application name and version

	        try {
	            JSONObject obj = (JSONObject)coolsms.send(params);
	            System.out.println(obj.toString());
	        } catch (CoolsmsException e) {
	        	
	        }
	}

	// 중복확인
	@Override
	public int checkIdDup(String userId) {
		int result = store.checkIdDup(userId);
		return result;
	}
	
	// 회원등록
	@Override
	public int registerUser(User user) {
		int result = store.insertUser(user);
		return result;
	}

	// 아이디 찾기 체크
	@Override
	public int checkUserId(User userOne) {
		int result = store.checkUserId(userOne);
		return result;
	}

	// 인증 메일 보내기
	@Override
	public void sendMail(String subject, String content, String sender, String receiver) {
		MimeMessage message = mailSender.createMimeMessage();
		try {
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
			messageHelper.setSubject(subject);
			messageHelper.setText(content, true);
			messageHelper.setFrom(new InternetAddress(sender));
			messageHelper.setTo(new InternetAddress(receiver));
			
			mailSender.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String showUserId(User userOne) {
		String userId = store.showUserId(userOne);
		return userId;
	}

	@Override
	public int checkUserPwd(User userOne) {
		int result = store.checkUserPwd(userOne);
		return result;
	}

	@Override
	public int modifyUserPwd(User userOne) {
		int result = store.updateUserPwd(userOne);
		return result;
	}

	

}
