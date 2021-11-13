package com.iei.greenlight.mypage.service.logic;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iei.greenlight.auction.domain.Auction;
import com.iei.greenlight.challenge.domain.Challenge;
import com.iei.greenlight.challenge.domain.PageInfo;
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


	

	
	

	

	

	

	
	

}
