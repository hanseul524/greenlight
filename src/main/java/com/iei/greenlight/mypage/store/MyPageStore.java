package com.iei.greenlight.mypage.store;

import java.util.HashMap;
import java.util.List;

import com.iei.greenlight.challenge.domain.Challenge;
import com.iei.greenlight.mypage.domain.PageInfo;
import com.iei.greenlight.mypage.domain.PointHistory;
import com.iei.greenlight.user.domain.User;

public interface MyPageStore {
	
	List<User> selectTotalPoint(String userId);
	
	List<PointHistory> selectTotalUse(String userId);
	
	List<PointHistory> selectPoint(HashMap<String, Object> hashmap);

	public int selectListCount(String userId);

}
