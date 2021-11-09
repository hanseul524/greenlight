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

	@Override
	public User printUser(String userId) {
		User user = store.selectUser(userId);
		return user;
	}

	@Override
	public int modifyUser(User user) {
		int result = store.updateUser(user);
		return result;
	}
	
	@Override
	public int removeUser(String userId) {
		int result = store.deleteUser(userId);
		return result;
	}
	
	@Override
	public List<Auction> printAllList(String userId) {
		System.out.println("서비스 : " + userId);
		List<Auction> aList = store.selectAllList(userId);
		return aList;
	}

	@Override
	public List<Auction> printList(String userId) {
		List<Auction> aList = store.selectList(userId);
		return aList;
	}

	

	

	

	
	

}
