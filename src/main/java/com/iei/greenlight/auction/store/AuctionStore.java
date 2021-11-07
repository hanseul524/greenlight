package com.iei.greenlight.auction.store;

import java.util.HashMap;
import java.util.List;

import com.iei.greenlight.auction.domain.Auction;
import com.iei.greenlight.auction.domain.AuctionImage;

public interface AuctionStore {
	
	// auction
	public int insertAuction(Auction auction);
	
	public List<Auction> selectAllList();

	
	//auctinoImage
	public int insertAuctionImage(List<AuctionImage> aList);
	
}
