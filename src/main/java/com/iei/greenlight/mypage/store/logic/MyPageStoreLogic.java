package com.iei.greenlight.mypage.store.logic;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iei.greenlight.auction.domain.Auction;
import com.iei.greenlight.challenge.domain.Challenge;
import com.iei.greenlight.event.domain.EventWinner;
import com.iei.greenlight.mypage.domain.AdCheck;
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

	
	@Override
	public int selectListCount(String userId) {
		int count = sqlSession.selectOne("pointMapper.selectListCount", userId);
		return count;
	}

	@Override
	public int insertAuctionBuyerPoint(User user) {
		int result = sqlSession.insert("pointMapper.insertBuyerPoint", user);
		return result;
	}

	@Override
	public int insertAuctionBuyerChargePoint(HashMap<String, Object> hashMap) {
		int result = sqlSession.insert("pointMapper.insertBuyerChargePoint", hashMap);
		return result;
	}

	@Override
	public int insertAuctionBuyerPointHistory(HashMap<String, Object> hashMap) {
		int result = sqlSession.insert("pointMapper.insertBuyerPointHistory", hashMap);
		return result;
	}

	@Override
	public int insertAuctionSellerPointHistory(HashMap<String, Object> hashMap) {
		int result = sqlSession.insert("pointMapper.insertSellerPointHistory", hashMap);
		return result;
	}
	
	@Override
	   public List<AdCheck> selectAdCheck(String userId) {
	      return sqlSession.selectList("adCheckMapper.selectAdList", userId);
	}
	
	@Override
	public int isertAdCheck(HashMap<String, Object> hashMap) {
		return sqlSession.insert("adCheckMapper.insertChecking", hashMap);
	}
	
	@Override
	public int updateContinuityPoint(HashMap<String, Object> hashMap) {
		return sqlSession.update("adCheckMapper.updateConPoint", hashMap);
	}

	@Override
	public int insertConHistory(HashMap<String, Object> hashMap) {
		return sqlSession.insert("pointMapper.insertConHistory", hashMap);
	}

	@Override
	public int updatePoint(HashMap<String, Object> hashMap) {
		return sqlSession.update("adCheckMapper.updatePoint", hashMap);
	}
	
	@Override
	public int insertHistory(HashMap<String, Object> hashMap) {
		return sqlSession.insert("pointMapper.inserHistory", hashMap);
	}

	@Override
	public int inserNonConAdCheck(String id) {
		return sqlSession.insert("adCheckMapper.inserNonConAdCheck", id);
	}

	@Override
	public int updateNonConPoint(String id) {
		return sqlSession.insert("adCheckMapper.updateNonConPoint", id);
	}

	@Override
	public int insertNonConHistory(String id) {
		return sqlSession.insert("pointMapper.inserNonConPointHistory", id);
	}

	@Override
	public int insertEventAnswerPointHistory(String userId) {
		return sqlSession.insert("pointMapper.insertEventAnswerPointHistory", userId);
	}

	@Override
	public int insertEventWinnerPointHistory(List<EventWinner> wList) {
		return sqlSession.insert("pointMapper.insertEventWinnerPointHistory", wList);
	}
}
