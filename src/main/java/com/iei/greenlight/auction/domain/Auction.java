package com.iei.greenlight.auction.domain;

import java.sql.Date;
import java.util.List;

public class Auction {
	
	private int auctionNo;
	private String userId;
	private String auctionTitle;
	private int auctionTime;
	private String auctionPrice;
	private Date regDate;
	private String varRegDate;
	private String fileName;
	private String filePath;
	private String fileMain;
//	private List<AuctionImage> aList;
	
	public Auction() {}
	
	public Auction(int auctionNo, String userId, String auctionTitle, int auctionTime, String auctionPrice, Date regDate,
			String varRegDate, String fileName, String filePath, String fileMain) {
		super();
		this.auctionNo = auctionNo;
		this.userId = userId;
		this.auctionTitle = auctionTitle;
		this.auctionTime = auctionTime;
		this.auctionPrice = auctionPrice;
		this.regDate = regDate;
		this.varRegDate = varRegDate;
		this.fileName = fileName;
		this.filePath = filePath;
		this.fileMain = fileMain;
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
	public String getAuctionPrice() {
		return auctionPrice;
	}
	public void setAuctionPrice(String auctionPrice) {
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
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getFileMain() {
		return fileMain;
	}
	public void setFileMain(String fileMain) {
		this.fileMain = fileMain;
	}
	@Override
	public String toString() {
		return "Auction [auctionNo=" + auctionNo + ", userId=" + userId + ", auctionTitle=" + auctionTitle
				+ ", auctionTime=" + auctionTime + ", auctionPrice=" + auctionPrice + ", regDate=" + regDate
				+ ", varRegDate=" + varRegDate + ", fileName=" + fileName + ", filePath=" + filePath + ", fileMain="
				+ fileMain + "]";
	}
	
		

	
	
}
