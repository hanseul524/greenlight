package com.iei.greenlight.mypage.service;

import java.util.List;

import com.iei.greenlight.auction.domain.Auction;
import com.iei.greenlight.mypage.domain.PointHistory;
import com.iei.greenlight.user.domain.User;

public interface MyPageService {

	List<PointHistory> printPoint(String userId);

	User printUser(String userId);
	
	int modifyUser(User user);
	
	int removeUser(String userId);
	
	List<Auction> printAllList(String userId);

	List<Auction> printList(String userId);
	
}
