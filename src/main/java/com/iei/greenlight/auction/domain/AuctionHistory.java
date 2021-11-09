package com.iei.greenlight.auction.domain;

import java.sql.Date;

public class AuctionHistory {
	
	private int auctionNo;
	private String userId;
	private Date regDate;
	private String auctionStart;
	private String auctionTitle;
	private String auctionStatus;
	private int auctionTime;
	private int auctionPrice;
	private String fileName;
	private String filePath;
	private String fileMain; 
	
	public AuctionHistory() {}
	
	public AuctionHistory(int auctionNo, String userId, Date regDate, String auctionStart, String auctionTitle,
			String auctionStatus, int auctionTime, int auctionPrice, String fileName, String filePath,
			String fileMain) {
		super();
		this.auctionNo = auctionNo;
		this.userId = userId;
		this.regDate = regDate;
		this.auctionStart = auctionStart;
		this.auctionTitle = auctionTitle;
		this.auctionStatus = auctionStatus;
		this.auctionTime = auctionTime;
		this.auctionPrice = auctionPrice;
		this.fileName = fileName;
		this.filePath = filePath;
		this.fileMain = fileMain;
	}



	public AuctionHistory(int auctionNo, String userId, Date regDate, String auctionStart, String auctionTitle,
			String auctionStatus, int auctionTime, int auctionPrice) {
		super();
		this.auctionNo = auctionNo;
		this.userId = userId;
		this.regDate = regDate;
		this.auctionStart = auctionStart;
		this.auctionTitle = auctionTitle;
		this.auctionStatus = auctionStatus;
		this.auctionTime = auctionTime;
		this.auctionPrice = auctionPrice;
	}

	public AuctionHistory(int auctionNo, String userId, String auctionStart, String auctionTitle, int auctionTime,
			int auctionPrice) {
		super();
		this.auctionNo = auctionNo;
		this.userId = userId;
		this.auctionStart = auctionStart;
		this.auctionTitle = auctionTitle;
		this.auctionTime = auctionTime;
		this.auctionPrice = auctionPrice;
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

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public String getAuctionStart() {
		return auctionStart;
	}

	public void setAuctionStart(String auctionStart) {
		this.auctionStart = auctionStart;
	}

	public String getAuctionTitle() {
		return auctionTitle;
	}

	public void setAuctionTitle(String auctionTitle) {
		this.auctionTitle = auctionTitle;
	}

	public String getAuctionStatus() {
		return auctionStatus;
	}

	public void setAuctionStatus(String auctionStatus) {
		this.auctionStatus = auctionStatus;
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
		return "AuctionHistory [auctionNo=" + auctionNo + ", userId=" + userId + ", regDate=" + regDate
				+ ", auctionStart=" + auctionStart + ", auctionTitle=" + auctionTitle + ", auctionStatus="
				+ auctionStatus + ", auctionTime=" + auctionTime + ", auctionPrice=" + auctionPrice + ", fileName="
				+ fileName + ", filePath=" + filePath + ", fileMain=" + fileMain + "]";
	}

}
