package com.iei.greenlight.auction.domain;

import java.sql.Date;

public class AuctionImage {
	
	private int auctionNo;
	private String userId;
	private String fileName;
	private String filePath;
	private long fileSize;
	private Date regDate;
	private String fileMain;
	
	public AuctionImage() {}
	
	public AuctionImage(String fileName, String filePath) {
		super();
		this.fileName = fileName;
		this.filePath = filePath;
	}

	public AuctionImage(int auctionNo, String userId, String fileName, String filePath, long fileSize, Date regDate,
			String fileMain) {
		super();
		this.auctionNo = auctionNo;
		this.userId = userId;
		this.fileName = fileName;
		this.filePath = filePath;
		this.fileSize = fileSize;
		this.regDate = regDate;
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

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public String getFileMain() {
		return fileMain;
	}

	public void setFileMain(String fileMain) {
		this.fileMain = fileMain;
	}

	@Override
	public String toString() {
		return "AuctionImage [auctionNo=" + auctionNo + ", userId=" + userId + ", fileName=" + fileName + ", filePath="
				+ filePath + ", fileSize=" + fileSize + ", regDate=" + regDate + ", fileMain=" + fileMain + "]";
	}
	

}
