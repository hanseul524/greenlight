package com.iei.greenlight.mypage.service.logic;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iei.greenlight.auction.domain.Auction;
import com.iei.greenlight.challenge.domain.Challenge;
import com.iei.greenlight.challenge.domain.PageInfo;
import com.iei.greenlight.mypage.domain.AdCheck;
import com.iei.greenlight.mypage.domain.PointHistory;
import com.iei.greenlight.mypage.service.MyPageService;
import com.iei.greenlight.mypage.store.MyPageStore;
import com.iei.greenlight.user.domain.User;

@Service
public class MyPageServiceImpl implements MyPageService{

	@Autowired
	private MyPageStore store;
	
	@Override
	public List<User> printTotalPoint(String userId) {
		return store.selectTotalPoint(userId);
	}

	@Override
	public List<PointHistory> printTotalUse(String userId) {
		// TODO Auto-generated method stub
		return store.selectTotalUse(userId);
	}
	
	@Override
	public List<PointHistory> printPoint(HashMap<String, Object> hashmap) {
		return store.selectPoint(hashmap);
	}

	@Override
	public int getListCount(String userId) {
		int totalCount = store.selectListCount(userId);
		return totalCount;
	}

	@Override
	public int registerAuctionBuyerPoint(User user) {
		int result = store.insertAuctionBuyerPoint(user);
		return result;
	}

	@Override
	public int registerAuctionBuyerChargePoint(HashMap<String, Object> hashMap) {
		int result = store.insertAuctionBuyerChargePoint(hashMap);
		return result;
	}

	@Override
	public int registerAuctionBuyerPointHistory(HashMap<String, Object> hashMap) {
		int result = store.insertAuctionBuyerPointHistory(hashMap);
		return result;
	}

	@Override
	public int registerAuctionSellerPointHistory(HashMap<String, Object> hashMap) {
		int result = store.insertAuctionSellerPointHistory(hashMap);
		return result;
	}
	
	@Override
	public List<AdCheck> printAdCheck(String userId) {
		return store.selectAdCheck(userId);
	}
	
	@Override
	public int addAdCheck(HashMap<String, Object> hashMap) {
		int result = 0;
		int adCheck = store.isertAdCheck(hashMap);
		int adPoint = store.updatePoint(hashMap);
		int pointHistory = store.insertHistory(hashMap);
		if(adCheck > 0 && pointHistory > 0 && adPoint > 0) {
			result = adCheck + pointHistory;
		}
		return result;
	}
	
	@Override
	public int addContinuityAdCheck(HashMap<String, Object> hashMap) {
		int result = 0;
		int adCheck = store.isertAdCheck(hashMap);
		int adPoint = store.updateContinuityPoint(hashMap);
		int pointHistory = store.insertConHistory(hashMap);
		if(adCheck > 0 && adPoint > 0 && pointHistory > 0) {
			result = adCheck + adPoint + pointHistory;
		}
		return result;
	}

	@Override
	public int addNonConAdCheck(String id) {
		int result = 0;
		int adCheck = store.inserNonConAdCheck(id);
		int adPoint = store.updateNonConPoint(id);
		int pointHistory = store.insertNonConHistory(id);
		if(adCheck > 0 && adPoint > 0 && pointHistory > 0) {
			result = adCheck + adPoint + pointHistory;
		}
		return result;
	}

	

	

	
	

	

	

	

	
	

}
