package com.iei.greenlight.mypage.store.logic;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iei.greenlight.auction.domain.Auction;
import com.iei.greenlight.mypage.domain.PointHistory;
import com.iei.greenlight.mypage.store.MyPageStore;
import com.iei.greenlight.user.domain.User;

@Repository
public class MyPageStoreLogic implements MyPageStore{

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<PointHistory> selectPoint(String userId) {
		List<PointHistory> point = sqlSession.selectList("pointMapper.selectPoint", userId);
		return point;
	}
	
	
	
	
	

	

	

	


}
