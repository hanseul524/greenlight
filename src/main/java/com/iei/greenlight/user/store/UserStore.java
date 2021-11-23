package com.iei.greenlight.user.store;

import java.util.HashMap;
import java.util.List;
import com.iei.greenlight.user.domain.User;
import com.iei.greenlight.event.domain.EventWinner;
import com.iei.greenlight.user.domain.PageInfo;

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
	
	public int updateEventAnswerPoint(String userId);
	
	public int updateEventWinnerPoint(String [] userId);

	public int checkSocialId(User userOne);

	public String socialIdLogin(String socialId);

	public int socialInsertUser(User user);
	
	public User selectUser(String userId);
	
	public int updateUser(User user);
	
	public int deleteUser(String userId);

	public int updateChargePoint(User userOne);

	public int updateCancelChargePoint(User user);
	 // 관리자 페이지
	public int selectListCount();
	
	public int selectSearchListCount(String userId);
	
	public List<User> selectSearchList(HashMap<String, Object> hashmap);
	   
	public List<User> selectUserList(PageInfo upi); 
	
	public int deleteUser(List<String> uList);
}
