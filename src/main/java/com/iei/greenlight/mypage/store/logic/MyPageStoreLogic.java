package com.iei.greenlight.mypage.store.logic;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iei.greenlight.auction.domain.Auction;
import com.iei.greenlight.challenge.domain.Challenge;
import com.iei.greenlight.mypage.domain.PageInfo;
import com.iei.greenlight.mypage.domain.PointHistory;
import com.iei.greenlight.mypage.store.MyPageStore;
import com.iei.greenlight.user.domain.User;

@Repository
public class MyPageStoreLogic implements MyPageStore{

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<User> selectTotalPoint(String userId) {
		return sqlSession.selectList("userMapper.selectTotalPoint", userId);
	}

	@Override
	public List<PointHistory> selectTotalUse(String userId) {
		return sqlSession.selectList("pointMapper.selectTotalUse", userId);
	}
	
	@Override
	public List<PointHistory> selectPoint(HashMap<String, Object> hashmap) {
		PageInfo pi = (PageInfo)(hashmap.get("pi"));
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		return sqlSession.selectList("pointMapper.selectPoint", hashmap, rowBounds);
	}

//	@Override
//	public List<Challenge> selectChallList(PageInfo pi) {
//		int offset = (pi.getCurrentPage()-1) * pi.getBoardLimit();
//		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
//		List<Challenge> cList = sqlSession.selectList("challengeMapper.selectAllList", pi, rowBounds);
//		return cList;
//	}
	
	@Override
	public int selectListCount(String userId) {
		int count = sqlSession.selectOne("pointMapper.selectListCount", userId);
		return count;
	}

	
	
	
	
	
	

	

	

	


}
