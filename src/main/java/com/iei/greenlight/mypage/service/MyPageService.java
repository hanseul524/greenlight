package com.iei.greenlight.mypage.service;

import java.util.HashMap;
import java.util.List;

import com.iei.greenlight.auction.domain.Auction;
import com.iei.greenlight.challenge.domain.Challenge;
import com.iei.greenlight.challenge.domain.PageInfo;
import com.iei.greenlight.mypage.domain.PointHistory;
import com.iei.greenlight.user.domain.User;

public interface MyPageService {
	
	List<User> printTotalPoint(String userId);
	
	List<PointHistory> printTotalUse(String userId);
	
	List<PointHistory> printPoint(HashMap<String, Object> hashmap);

//	List<Challenge> printChallList(PageInfo pi);
	
	public int getListCount(String userId);
	
}
