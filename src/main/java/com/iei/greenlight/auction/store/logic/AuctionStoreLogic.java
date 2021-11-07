package com.iei.greenlight.auction.store.logic;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iei.greenlight.auction.domain.Auction;
import com.iei.greenlight.auction.domain.AuctionImage;
import com.iei.greenlight.auction.store.AuctionStore;

@Repository
public class AuctionStoreLogic implements AuctionStore{
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	

	@Override
	public List<Auction> selectAllList() {
		
		List<Auction> aList = sqlSession.selectList("auctionMapper.selectAllList");
		
		return aList;
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


}
