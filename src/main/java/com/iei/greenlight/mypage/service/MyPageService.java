package com.iei.greenlight.mypage.service;

import java.util.HashMap;
import java.util.List;

import com.iei.greenlight.auction.domain.Auction;
import com.iei.greenlight.challenge.domain.Challenge;
import com.iei.greenlight.challenge.domain.PageInfo;
import com.iei.greenlight.mypage.domain.AdCheck;
import com.iei.greenlight.mypage.domain.PointHistory;
import com.iei.greenlight.user.domain.User;

public interface MyPageService {
	
	List<User> printTotalPoint(String userId);
	
	List<PointHistory> printTotalUse(String userId);
	
	List<PointHistory> printPoint(HashMap<String, Object> hashmap);

	public int getListCount(String userId);

	public List<AdCheck> printAdCheck(String userId);
	
	public int addAdCheck(HashMap<String, Object> hashMap);

	public int addContinuityAdCheck(HashMap<String, Object> hashMap);
	
	public int addNonConAdCheck(String id);

	public int registerAuctionBuyerPoint(User user);
	public int registerAuctionBuyerChargePoint(HashMap<String, Object> hashMap);
	public int registerAuctionBuyerPointHistory(HashMap<String, Object> hashMap);
	public int registerAuctionSellerPointHistory(HashMap<String, Object> hashMap);
	
}
