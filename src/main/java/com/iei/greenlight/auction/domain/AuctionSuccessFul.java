package com.iei.greenlight.auction.domain;

import java.sql.Date;

public class AuctionSuccessFul {
	
	private int auctionNo;
	private String buyer;
	private String seller;
	private int auctionPrice;
	private Date auctionDate;
	private String auctionReceipt;
	private String auctionTitle;
	private int count;
	
	public AuctionSuccessFul() {}
	
	public AuctionSuccessFul(int auctionNo, String buyer, String seller, int auctionPrice, Date auctionDate,
			String auctionReceipt, String auctionTitle, int count) {
		super();
		this.auctionNo = auctionNo;
		this.buyer = buyer;
		this.seller = seller;
		this.auctionPrice = auctionPrice;
		this.auctionDate = auctionDate;
		this.auctionReceipt = auctionReceipt;
		this.auctionTitle = auctionTitle;
		this.count = count;
	}

	public AuctionSuccessFul(int auctionNo, String buyer, String seller, int auctionPrice, String auctionTitle) {
		super();
		this.auctionNo = auctionNo;
		this.buyer = buyer;
		this.seller = seller;
		this.auctionPrice = auctionPrice;
		this.auctionTitle = auctionTitle;
	}

	public int getAuctionNo() {
		return auctionNo;
	}

	public void setAuctionNo(int auctionNo) {
		this.auctionNo = auctionNo;
	}

	public String getBuyer() {
		return buyer;
	}

	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}

	public String getSeller() {
		return seller;
	}

	public void setSeller(String seller) {
		this.seller = seller;
	}

	public int getAuctionPrice() {
		return auctionPrice;
	}

	public void setAuctionPrice(int auctionPrice) {
		this.auctionPrice = auctionPrice;
	}

	public Date getAuctionDate() {
		return auctionDate;
	}

	public void setAuctionDate(Date auctionDate) {
		this.auctionDate = auctionDate;
	}

	public String getAuctionReceipt() {
		return auctionReceipt;
	}

	public void setAuctionReceipt(String auctionReceipt) {
		this.auctionReceipt = auctionReceipt;
	}

	public String getAuctionTitle() {
		return auctionTitle;
	}

	public void setAuctionTitle(String auctionTitle) {
		this.auctionTitle = auctionTitle;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "AuctionSuccessFul [auctionNo=" + auctionNo + ", buyer=" + buyer + ", seller=" + seller
				+ ", auctionPrice=" + auctionPrice + ", auctionDate=" + auctionDate + ", auctionReceipt="
				+ auctionReceipt + ", auctionTitle=" + auctionTitle + ", count=" + count + "]";
	}
	
	

}
