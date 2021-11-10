package com.iei.greenlight.mypage.service.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iei.greenlight.auction.domain.Auction;
import com.iei.greenlight.mypage.domain.PointHistory;
import com.iei.greenlight.mypage.service.MyPageService;
import com.iei.greenlight.mypage.store.MyPageStore;
import com.iei.greenlight.user.domain.User;

@Service
public class MyPageServiceImpl implements MyPageService{

	@Autowired
	private MyPageStore store;
	
	@Override
	public List<PointHistory> printPoint(String userId) {
		List<PointHistory> point = store.selectPoint(userId);
		return point;
	}


	
	

	

	

	

	
	

}
