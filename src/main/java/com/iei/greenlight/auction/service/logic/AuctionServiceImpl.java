package com.iei.greenlight.auction.service.logic;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iei.greenlight.auction.domain.Auction;
import com.iei.greenlight.auction.domain.AuctionImage;
import com.iei.greenlight.auction.service.AuctionService;
import com.iei.greenlight.auction.store.AuctionStore;

@Service
public class AuctionServiceImpl implements AuctionService{
	
	@Autowired
	private AuctionStore store;
	

	@Override
	public List<Auction> printAllList() {
		
		List<Auction> aList = store.selectAllList();
		
		return aList;
	}
	

	@Override
	public int registerAuction(Auction auction) {
		
		int result = store.insertAuction(auction);
		
		return result;
	}

	@Override
	public int registerAuctionImage(List<AuctionImage> aList) {
		
		int result = store.insertAuctionImage(aList);
		
		return result;
	}



}
