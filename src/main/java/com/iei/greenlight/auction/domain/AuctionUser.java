package com.iei.greenlight.auction.domain;

public class AuctionUser {
	
	private int auctionNo;
	private String userId;
	private int point;
	
	public AuctionUser() {}

	public AuctionUser(int auctionNo, String userId, int point) {
		super();
		this.auctionNo = auctionNo;
		this.userId = userId;
		this.point = point;
	}

	public int getAuctionNo() {
		return auctionNo;
	}

	public void setAuctionNo(int auctionNo) {
		this.auctionNo = auctionNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	@Override
	public String toString() {
		return "AuctionUser [auctionNo=" + auctionNo + ", userId=" + userId + ", point=" + point + "]";
	}
	
	

}
