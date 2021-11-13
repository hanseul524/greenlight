package com.iei.greenlight.auction.service;

import java.util.HashMap;
import java.util.List;

import com.iei.greenlight.auction.domain.AdminPageInfo;
import com.iei.greenlight.auction.domain.Auction;
import com.iei.greenlight.auction.domain.AuctionHistory;
import com.iei.greenlight.auction.domain.AuctionImage;
import com.iei.greenlight.auction.domain.AuctionSuccessFul;
import com.iei.greenlight.auction.domain.AuctionUser;
import com.iei.greenlight.auction.domain.PageInfo;

public interface AuctionService {
	
	
	// Auction
	public List<Auction> printAuctionAllList(AdminPageInfo pi);
	public int getAdminListCount();
	public int getListCount();
	public Auction printAuctionOneByNo(int auctionNo);
	public int registerAuction(Auction auction);
	public int removeAuction(int[] auctionNo);
	
	// AuctionImage
	public List<AuctionImage> printAuctionImageOneByNo(int auctionNo);
	public int registerAuctionImage(List<AuctionImage> aList);
	public int removeAuctionImage(int[] auctionNo);
	
	// AuctionHistory
	public List<AuctionHistory> printAllList(PageInfo pi);
	public AuctionHistory printAuctionHistoryOneByNo(int auctionNo);
	public int registerAuctionHistory(List<AuctionHistory> hList);
	public int modifyAuctionHistory(int auctionNo);
	
	// AuctionUser
	public AuctionUser printAuctionUser(int auctionNo);
	public int registerAuctionUser(AuctionUser auctionUser);
	public int removeAuctionUser(int[] auctionNo);
	
	// AuctionSuccessFul
	public List<AuctionSuccessFul> printSuccessFulList();
	public List<AuctionSuccessFul> printSuccessFulByNo(HashMap<String, int[]> map);
	public int registerAuctionSuccessFul(AuctionSuccessFul auctionSuccessFul);
	public int modifyAuctionSuccessFul(int[] auctionNo);
	
	// mypage
    public List<AuctionHistory> printAllList(String userId);
    public List<AuctionHistory> printList(String userId);
	


	
}
