package com.iei.greenlight.mypage.store.logic;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iei.greenlight.auction.domain.Auction;
import com.iei.greenlight.mypage.store.MyPageStore;
import com.iei.greenlight.user.domain.User;

@Repository
public class MyPageStoreLogic implements MyPageStore{

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public User selectUser(String userId) {
		User user = sqlSession.selectOne("userMapper.selectUserOne", userId);
		return user;
	}
	
	@Override
	public List<Auction> selectAllList(String userId) {
		System.out.println("서비스 : " + userId);
		List<Auction> aList = sqlSession.selectList("auctionMapper.selectMyAuctionList", userId);
		return aList;
	}


}
