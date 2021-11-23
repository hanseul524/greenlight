package com.iei.greenlight.user.service;

import java.util.HashMap;
import java.util.List;
import com.iei.greenlight.user.domain.PageInfo;
import com.iei.greenlight.event.domain.EventWinner;
import com.iei.greenlight.mypage.domain.PointHistory;
import com.iei.greenlight.user.domain.User;

public interface UserService {

	public User loginUser(User user);

	public void certifiedPhoneNumber(String phoneNumber, String numStr);

	public int registerUser(User user);

	public int checkIdDup(String userId);

	public int checkUserId(User userOne);
	
	public void sendMail(String subject, String content, String sender, String receiver);

	public String showUserId(User userOne);

	public int checkUserPwd(User userOne);

	public int modifyUserPwd(User userOne);
	
	public int modifyUserPoint(HashMap<String, Object> pointMap);
	
	public int modifyUserMinusPoint(HashMap<String, Object> pointMap);
	
	public int modifyUserChargePoint(HashMap<String, Object> chargePointMap);
	
	public int modifySellerPoint(HashMap<String, Object> pointMap);
	
	public int modifyEventAnswerPoint(String userId);
	
	public int modifyEventWinnerPoint(String [] userId);

	public int checkSocialId(User userOne);

	public String socialIdLogin(String socialId);

	public int socialRegisterUser(User user);
	
	public User printUser(String userId);
	
	public int modifyUser(User user);
	
	public int removeUser(String userId);

	public int modifyChargePoint(User userOne);

	public int modifycancelChargePoin(User user);
	// 관리자 페이지
	public int getListCount();
	
	public int getSearchListCount(String userId);
	
	public List<User> printSearchList(HashMap<String, Object> hashmap);
	
	public List<User> showUserList(PageInfo upi); 
	
	public int removeUser(List<String> uList);
}
