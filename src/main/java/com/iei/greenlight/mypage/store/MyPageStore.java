package com.iei.greenlight.mypage.store;

import java.util.List;

import com.iei.greenlight.auction.domain.Auction;
import com.iei.greenlight.mypage.domain.PointHistory;
import com.iei.greenlight.user.domain.User;

public interface MyPageStore {
	
	List<PointHistory> selectPoint(String userId);

	User selectUser(String userId);
	
	int updateUser(User user);
	
	int deleteUser(String userId);
	
	public List<Auction> selectAllList(String userId);
	
	public List<Auction> selectList(String userId);

}
