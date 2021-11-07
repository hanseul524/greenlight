package com.iei.greenlight.user.service.logic;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
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
	
	@Override
	public User loginUser(User user) {
		User userOne = store.loginUser(user);
		return userOne;
	}

	@Override
	public void certifiedPhoneNumber(String phoneNumber, String numStr) {
		 String api_key = "NCSONNV2NIS96BTQ";
	        String api_secret = "UX41HUMQS2AVNJEZCDJFQUNCWGIFVUNR";
	        Message coolsms = new Message(api_key, api_secret);

	        // 4 params(to, from, type, text) are mandatory. must be filled
	        HashMap<String, String> params = new HashMap<String, String>();
	        params.put("to", phoneNumber);    // ������ȭ��ȣ
	        params.put("from", "01092809673");    // �߽���ȭ��ȣ. �׽�Ʈ�ÿ��� �߽�,���� �Ѵ� ���� ��ȣ�� �ϸ� ��
	        params.put("type", "SMS");
	        params.put("text", "�޴������� �޽��� : ������ȣ��" + "["+numStr+"]" + "�Դϴ�.");
	        params.put("app_version", "test app 1.2"); // application name and version

	        try {
	            JSONObject obj = (JSONObject)coolsms.send(params);
	            System.out.println(obj.toString());
	        } catch (CoolsmsException e) {
	            System.out.println(e.getMessage());
	            System.out.println(e.getCode());
	        }
	}

	@Override
	public int checkIdDup(String userId) {
		int result = store.checkIdDup(userId);
		return result;
	}
	
	@Override
	public int registerUser(User user) {
		int result = store.insertUser(user);
		return result;
	}

	

}
