package com.iei.greenlight.auction.service;

import java.util.HashMap;
import java.util.List;

import com.iei.greenlight.auction.domain.Auction;
import com.iei.greenlight.auction.domain.AuctionImage;

public interface AuctionService {
	
	
	// Auction
	public List<Auction> printAllList();
	public int getListCount();
	public Auction printAuctionOneByNo(int auctionNo);
	public List<AuctionImage> printAuctionImageOneByNo(int auctionNo);
	public int registerAuction(Auction auction);
	
	
	
	
	// AuctionImage
	public int registerAuctionImage(List<AuctionImage> aList);

	
}
