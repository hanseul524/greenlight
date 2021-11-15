package com.iei.greenlight.auction.store.logic;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iei.greenlight.auction.domain.AdminPageInfo;
import com.iei.greenlight.auction.domain.Auction;
import com.iei.greenlight.auction.domain.AuctionHistory;
import com.iei.greenlight.auction.domain.AuctionImage;
import com.iei.greenlight.auction.domain.AuctionSuccessFul;
import com.iei.greenlight.auction.domain.AuctionUser;
import com.iei.greenlight.auction.domain.PageInfo;
import com.iei.greenlight.auction.store.AuctionStore;

@Repository
public class AuctionStoreLogic implements AuctionStore{
	
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	
	@Override
	public List<Auction> selectAuctionAllList(AdminPageInfo pi) {
		
		int offset = (pi.getCurrentPage()-1) * pi.getAuctionLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getAuctionLimit());
		return sqlSession.selectList("auctionMapper.selectAuctionList", pi, rowBounds);
	}
	
	@Override
	public List<AuctionHistory> selectAllList(PageInfo pi) {
		
		int offset = (pi.getCurrentPage()-1) * pi.getAuctionLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getAuctionLimit());
		return sqlSession.selectList("auctionMapper.selectAllList", pi, rowBounds);
	}

	@Override
	public int selectListCount() {
		return sqlSession.selectOne("auctionMapper.selectHistoryListCount");
	}
	
	@Override
	public int selectAdminListCount() {
		return sqlSession.selectOne("auctionMapper.selectListCount");
	}

	@Override
	public Auction selectAuctionOneByNo(int auctionNo) {
		return sqlSession.selectOne("selectAuctionOneByNo", auctionNo);
	}
	
	@Override
	public AuctionHistory selectAuctionHistoryOneByNo(int auctionNo) {
		return sqlSession.selectOne("auctionMapper.selectHistoryOneByNo", auctionNo);
	}
	
	@Override
	public int deleteAuction(int[] auctionNo) {
		return sqlSession.delete("auctionMapper.deleteAuction", auctionNo);
	}

	@Override
	public List<AuctionImage> selectAuctionImageOneByNo(int auctionNo) {
		return sqlSession.selectList("auctionMapper.selectAuctionImage", auctionNo);
	}

	@Override
	public int insertAuction(Auction auction) {
		return sqlSession.insert("auctionMapper.insertAuction", auction);
	}

	@Override
	public int insertAuctionImage(List<AuctionImage> aList) {
		return sqlSession.insert("auctionMapper.insertAuctionImage", aList);
	}
	
	@Override
	public int deleteAuctionImage(int[] auctionNo) {
		return sqlSession.delete("auctionMapper.deleteAuctionImage", auctionNo);
	}
	
	@Override
	public int insertAuctionHistory(List<AuctionHistory> hList) {
		return sqlSession.insert("auctionMapper.insertAuctionHistory", hList);
	}
	
	@Override
	public int updateAuctionHistory(int auctionNo) {
		return sqlSession.update("auctionMapper.updateAuctionHistory", auctionNo);
	}

	@Override
	public AuctionUser selectAuctionUser(int auctionNo) {
		return sqlSession.selectOne("auctionMapper.selectAuctionUser", auctionNo);
	}

	@Override
	public int insertAuctionUser(AuctionUser auctionUser) {
		return sqlSession.insert("auctionMapper.insertAuctionUser", auctionUser);
	}

	@Override
	public int deleteAuctionUser(int[] auctionNo) {
		return sqlSession.delete("auctionMapper.deleteAuctionUser", auctionNo);
	}
	
	@Override
	public List<AuctionSuccessFul> selectAuctionSuccessFul() {
		return sqlSession.selectList("auctionMapper.selectAuctionSuccessFulList");
	}

	@Override
	public List<AuctionSuccessFul> selectAuctionSuccessFulByNo(HashMap<String, int[]> map) {
		return sqlSession.selectList("auctionMapper.selectAuctionSuccessFulByNo", map);
	}

	@Override
	public int insertAuctionSuccessFul(AuctionSuccessFul auctionSuccessFul) {
		return sqlSession.insert("auctionMapper.insertAuctionSuccessFul", auctionSuccessFul);
	}
	
	@Override
	public int updateAuctionSuccessFul(int[] auctionNo) {
		return sqlSession.update("auctionMapper.updateAuctionSuccessFul", auctionNo);
	}
	
	// 스토어 로직 수정
	@Override
	public int selectMyListCount(String userId) {
		return sqlSession.selectOne("auctionMapper.selectMyHistory", userId);
	}
	
	@Override
	public int selectMyAuctionCount(String userId) {
		return sqlSession.selectOne("auctionMapper.selectMyBidList", userId);
	}
	
	@Override
	public List<AuctionHistory> selectAllList(HashMap<String, Object> hashMap) {
		PageInfo pi = (PageInfo)(hashMap.get("pi"));
		int offset = (pi.getCurrentPage() - 1) * pi.getAuctionLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getAuctionLimit());
		List<AuctionHistory> aList = sqlSession.selectList("auctionMapper.selectMyAuctionList", hashMap, rowBounds);
		return aList;
	}

	@Override
	public List<AuctionHistory> selectList(HashMap<String, Object> hashMap) {
		PageInfo pi = (PageInfo)(hashMap.get("pi"));
		int offset = (pi.getCurrentPage() - 1) * pi.getAuctionLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getAuctionLimit());
		List<AuctionHistory> aList = sqlSession.selectList("auctionMapper.selectList", hashMap, rowBounds);
		return aList;
	}

}
