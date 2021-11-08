package com.iei.greenlight.mypage.service;

import java.util.List;

import com.iei.greenlight.auction.domain.Auction;
import com.iei.greenlight.user.domain.User;

public interface MyPageService {

	User printUser(String userId);
	
	List<Auction> printAllList(String userId);
}
