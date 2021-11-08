package com.iei.greenlight.mypage.service.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iei.greenlight.auction.domain.Auction;
import com.iei.greenlight.mypage.service.MyPageService;
import com.iei.greenlight.mypage.store.MyPageStore;
import com.iei.greenlight.user.domain.User;

@Service
public class MyPageServiceImpl implements MyPageService{

	@Autowired
	private MyPageStore store;
	
	@Override
	public User printUser(String userId) {
		User user = store.selectUser(userId);
		return user;
	}

	@Override
	public List<Auction> printAllList(String userId) {
		System.out.println("서비스 : " + userId);
		List<Auction> aList = store.selectAllList(userId);
		return aList;
	}

	
	

}
