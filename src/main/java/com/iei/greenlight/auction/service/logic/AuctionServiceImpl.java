package com.iei.greenlight.auction.service.logic;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iei.greenlight.auction.domain.AdminPageInfo;
import com.iei.greenlight.auction.domain.Auction;
import com.iei.greenlight.auction.domain.AuctionHistory;
import com.iei.greenlight.auction.domain.AuctionImage;
import com.iei.greenlight.auction.domain.AuctionSuccessFul;
import com.iei.greenlight.auction.domain.AuctionUser;
import com.iei.greenlight.auction.domain.PageInfo;
import com.iei.greenlight.auction.service.AuctionService;
import com.iei.greenlight.auction.store.AuctionStore;

@Service
public class AuctionServiceImpl implements AuctionService{
	
	@Autowired
	private AuctionStore store;
	
	@Override
	public List<Auction> printAuctionAllList(AdminPageInfo pi) {
		return store.selectAuctionAllList(pi);
	}
	

	@Override
	public List<AuctionHistory> printAllList(PageInfo pi) {
		return store.selectAllList(pi);
	}


	@Override
	public int getAdminListCount() {
		return store.selectAdminListCount();
	}
	
	@Override
	public int getListCount() {
		return store.selectListCount();
	}


	@Override
	public Auction printAuctionOneByNo(int auctionNo) {
		return store.selectAuctionOneByNo(auctionNo);
	}


	@Override
	public AuctionHistory printAuctionHistoryOneByNo(int auctionNo) {
		return store.selectAuctionHistoryOneByNo(auctionNo);
	}

	@Override
	public List<AuctionImage> printAuctionImageOneByNo(int auctionNo) {
		return store.selectAuctionImageOneByNo(auctionNo);
	}
	

	@Override
	public int registerAuction(Auction auction) {
		return store.insertAuction(auction);
	}
	

	@Override
	public int removeAuction(int[] auctionNo) {
		return store.deleteAuction(auctionNo);
	}


	@Override
	public int registerAuctionImage(List<AuctionImage> aList) {
		return store.insertAuctionImage(aList);
	}
	

	@Override
	public int removeAuctionImage(int[] auctionNo) {
		return store.deleteAuctionImage(auctionNo);
	}
	
	
	@Override
	public int registerAuctionHistory(List<AuctionHistory> hList) {
		return store.insertAuctionHistory(hList);
	}
	
	

	@Override
	public int modifyAuctionHistory(int auctionNo) {
		return store.updateAuctionHistory(auctionNo);
	}



	@Override
	public AuctionUser printAuctionUser(int auctionNo) {
		return store.selectAuctionUser(auctionNo);
	}


	@Override
	public int registerAuctionUser(AuctionUser auctionUser) {
		return store.insertAuctionUser(auctionUser);
	}
	

	@Override
	public int removeAuctionUser(int[] auctionNo) {
		return store.deleteAuctionUser(auctionNo);
	}


	@Override
	public List<AuctionSuccessFul> printSuccessFulList() {
		return store.selectAuctionSuccessFul();
	}


	@Override
	public List<AuctionSuccessFul> printSuccessFulByNo(HashMap<String, int[]> map) {
		return store.selectAuctionSuccessFulByNo(map);
	}
	
	@Override
	public int registerAuctionSuccessFul(AuctionSuccessFul auctionSuccessFul) {
		return store.insertAuctionSuccessFul(auctionSuccessFul);
	}

	@Override
	public int modifyAuctionSuccessFul(int[] auctionNo) {
		return store.updateAuctionSuccessFul(auctionNo);
	}
	
	@Override
	public int getMyListCount(String userId) {
		return store.selectMyListCount(userId);
	}
	
	@Override
	public int getMyAuctionCount(String userId) {
		return store.selectMyAuctionCount(userId);
	}
	
	// 서비스 로직
	@Override
	public List<AuctionHistory> printAllList(HashMap<String, Object> hashMap) {
		return store.selectAllList(hashMap);
	}

	@Override
	public List<AuctionHistory> printList(HashMap<String, Object> hashMap) {
		return store.selectList(hashMap);
	}


	





}
