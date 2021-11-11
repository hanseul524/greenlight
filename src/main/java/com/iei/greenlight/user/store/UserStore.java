package com.iei.greenlight.user.store;

import java.util.HashMap;

import com.iei.greenlight.user.domain.User;

public interface UserStore {

	public User loginUser(User user);

	public int insertUser(User user);

	public int checkIdDup(String userId);

	public int checkUserId(User userOne);

	public String showUserId(User userOne);

	public int checkUserPwd(User userOne);

	public int updateUserPwd(User userOne);
	
	public int updateUserPoint(HashMap<String, Object> pointMap);
	
	public int updateUserMinusPoint(HashMap<String, Object> pointMap);
	
	public int updateUserChargePoint(HashMap<String, Object> chargePointMap);
	
	public int updateSellerPoint(HashMap<String, Object> pointMap);

	public int checkSocialId(User userOne);

	public String socialIdLogin(String socialId);

	public int socialInsertUser(User user);
	
	User selectUser(String userId);
	
	int updateUser(User user);
	
	int deleteUser(String userId);
}
