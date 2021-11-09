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
		List<Auction> aList = sqlSession.selectList("auctionMapper.selectAuctionList", pi, rowBounds);
		
		return aList;
	}

	
	
	@Override
	public List<AuctionHistory> selectAllList(PageInfo pi) {
		
		int offset = (pi.getCurrentPage()-1) * pi.getAuctionLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getAuctionLimit());
		List<AuctionHistory> aList = sqlSession.selectList("auctionMapper.selectAllList", pi, rowBounds);
		
		return aList;
	}

	@Override
	public int selectListCount() {
		
		int count = sqlSession.selectOne("auctionMapper.selectHistoryListCount");
		
		return count;
	}
	

	@Override
	public int selectAdminListCount() {
		
		int count = sqlSession.selectOne("auctionMapper.selectListCount");
		
		return count;
	}
	

	@Override
	public Auction selectAuctionOneByNo(int auctionNo) {
		
		Auction auction = sqlSession.selectOne("selectAuctionOneByNo", auctionNo);
		
		return auction;
	}

	
	@Override
	public AuctionHistory selectAuctionHistoryOneByNo(int auctionNo) {
		
		AuctionHistory auctionHistory = sqlSession.selectOne("auctionMapper.selectHistoryOneByNo", auctionNo);
		
		return auctionHistory;
	}
	
	@Override
	public int deleteAuction(int[] auctionNo) {
		
		int result = sqlSession.delete("auctionMapper.deleteAuction", auctionNo);
		
		return result;
	}

	
	@Override
	public List<AuctionImage> selectAuctionImageOneByNo(int auctionNo) {
		
		List<AuctionImage> imageList = sqlSession.selectList("auctionMapper.selectAuctionImage", auctionNo);
		
		return imageList;
	}

	@Override
	public int insertAuction(Auction auction) {
		
		int result = sqlSession.insert("auctionMapper.insertAuction", auction);
		
		return result;
	}

	@Override
	public int insertAuctionImage(List<AuctionImage> aList) {
		
		int result = sqlSession.insert("auctionMapper.insertAuctionImage", aList);
		
		return result;
	}

	
	@Override
	public int insertAuctionHistory(List<AuctionHistory> hList) {
		
		int result = sqlSession.insert("auctionMapper.insertAuctionHistory", hList);
		
		return result;
	}


	@Override
	public AuctionUser selectAuctionUser(int auctionNo) {
		
		AuctionUser auctionUser = sqlSession.selectOne("auctionMapper.selectAuctionUser", auctionNo);
		
		return auctionUser;
	}



	@Override
	public int insertAuctionUser(AuctionUser auctionUser) {
		
		int result = sqlSession.insert("auctionMapper.insertAuctionUser", auctionUser);
		
		return result;
	}


}
