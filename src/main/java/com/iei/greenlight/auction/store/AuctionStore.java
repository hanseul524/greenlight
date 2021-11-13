package com.iei.greenlight.auction.store;

import java.util.HashMap;
import java.util.List;

import com.iei.greenlight.auction.domain.AdminPageInfo;
import com.iei.greenlight.auction.domain.Auction;
import com.iei.greenlight.auction.domain.AuctionHistory;
import com.iei.greenlight.auction.domain.AuctionImage;
import com.iei.greenlight.auction.domain.AuctionSuccessFul;
import com.iei.greenlight.auction.domain.AuctionUser;
import com.iei.greenlight.auction.domain.PageInfo;

public interface AuctionStore {
	
	// Auction
	public List<Auction> selectAuctionAllList(AdminPageInfo pi);
	public int selectAdminListCount();
	public int selectListCount();
	public Auction selectAuctionOneByNo(int auctionNo);
	public int insertAuction(Auction auction);
	public int deleteAuction(int[] auctionNo);

	// AuctinoImage
	public List<AuctionImage> selectAuctionImageOneByNo(int auctionNo);
	public int insertAuctionImage(List<AuctionImage> aList);
	public int deleteAuctionImage(int[] auctionNo);
	
	// AuctionHistory
	public List<AuctionHistory> selectAllList(PageInfo pi);
	public AuctionHistory selectAuctionHistoryOneByNo(int auctionNo);
	public int insertAuctionHistory(List<AuctionHistory> hList);
	public int updateAuctionHistory(int auctionNo);
	
	// AuctionUser
	public AuctionUser selectAuctionUser(int auctionNo);
	public int insertAuctionUser(AuctionUser auctionUser);
	public int deleteAuctionUser(int[] auctionNo);
	
	// AuctionSuccessFul
	public List<AuctionSuccessFul> selectAuctionSuccessFul();
	public List<AuctionSuccessFul> selectAuctionSuccessFulByNo(HashMap<String, int[]> map);
	public int insertAuctionSuccessFul(AuctionSuccessFul auctionSuccessFul);
	public int updateAuctionSuccessFul(int[] auctionNo);
	
	// mypage
	public List<AuctionHistory> selectAllList(String userId);
	public List<AuctionHistory> selectList(String userId);
	
}
