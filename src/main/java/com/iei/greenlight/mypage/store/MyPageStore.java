package com.iei.greenlight.mypage.store;

import java.util.List;

import com.iei.greenlight.auction.domain.Auction;
import com.iei.greenlight.mypage.domain.PointHistory;
import com.iei.greenlight.user.domain.User;

public interface MyPageStore {
	
	List<PointHistory> selectPoint(String userId);

	
	
	
	

}
