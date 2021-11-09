package com.iei.greenlight.auction.domain;

import java.sql.Date;
import java.util.List;

public class Auction {
	
	private int auctionNo;
	private String userId;
	private String auctionTitle;
	private int auctionTime;
	private int auctionPrice;
	private Date regDate;
	private String varRegDate;
//	private List<AuctionImage> aList;
	
	public Auction() {}
	
	public Auction(int auctionNo, String userId, String auctionTitle, int auctionTime, int auctionPrice, Date regDate,
			String varRegDate) {
		super();
		this.auctionNo = auctionNo;
		this.userId = userId;
		this.auctionTitle = auctionTitle;
		this.auctionTime = auctionTime;
		this.auctionPrice = auctionPrice;
		this.regDate = regDate;
		this.varRegDate = varRegDate;
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
	
	public String getAuctionTitle() {
		return auctionTitle;
	}
	
	public void setAuctionTitle(String auctionTitle) {
		this.auctionTitle = auctionTitle;
	}
	
	public int getAuctionTime() {
		return auctionTime;
	}
	
	public void setAuctionTime(int auctionTime) {
		this.auctionTime = auctionTime;
	}
	
	public int getAuctionPrice() {
		return auctionPrice;
	}
	
	public void setAuctionPrice(int auctionPrice) {
		this.auctionPrice = auctionPrice;
	}
	
	public Date getRegDate() {
		return regDate;
	}
	
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
	public String getVarRegDate() {
		return varRegDate;
	}
	
	public void setVarRegDate(String varRegDate) {
		this.varRegDate = varRegDate;
	}
	
	
	@Override
	public String toString() {
		return "Auction [auctionNo=" + auctionNo + ", userId=" + userId + ", auctionTitle=" + auctionTitle
				+ ", auctionTime=" + auctionTime + ", auctionPrice=" + auctionPrice + ", regDate=" + regDate
				+ ", varRegDate=" + varRegDate + "]";
	}

	
	
	
}
