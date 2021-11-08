package com.iei.greenlight.auction.store;

import java.util.HashMap;
import java.util.List;

import com.iei.greenlight.auction.domain.Auction;
import com.iei.greenlight.auction.domain.AuctionImage;

public interface AuctionStore {
	
	// auction
	public List<Auction> selectAllList();
	public int selectListCount();
	public Auction selectAuctionOneByNo(int auctionNo);
	public List<AuctionImage> selectAuctionImageOneByNo(int auctionNo);
	public int insertAuction(Auction auction);
	

	
	//auctinoImage
	public int insertAuctionImage(List<AuctionImage> aList);
	
}
