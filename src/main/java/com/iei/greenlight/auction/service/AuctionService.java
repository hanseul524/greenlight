package com.iei.greenlight.auction.service;

import java.util.HashMap;
import java.util.List;

import com.iei.greenlight.auction.domain.Auction;
import com.iei.greenlight.auction.domain.AuctionImage;

public interface AuctionService {
	
	
	// Auction
	public int registerAuction(Auction auction);
	
	List<Auction> printAllList();
	
	
	
	// AuctionImage
	public int registerAuctionImage(List<AuctionImage> aList);

	
}
