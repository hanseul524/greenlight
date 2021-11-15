package com.iei.greenlight.donationBoard.domain;

import java.sql.Date;

public class DtFile {

	private int boradNo;
	private String fileName;
	private String filePath;
	private long fileSize;
	private Date uploadDate;
	
	public DtFile() {}

	public DtFile(int boradNo, String fileName, String filePath, long fileSize, Date uploadDate) {
		super();
		this.boradNo = boradNo;
		this.fileName = fileName;
		this.filePath = filePath;
		this.fileSize = fileSize;
		this.uploadDate = uploadDate;
	}

	public int getBoradNo() {
		return boradNo;
	}

	public void setBoradNo(int boradNo) {
		this.boradNo = boradNo;
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

	public Date getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	@Override
	public String toString() {
		return "DtFile [boradNo=" + boradNo + ", fileName=" + fileName + ", filePath=" + filePath + ", fileSize="
				+ fileSize + ", uploadDate=" + uploadDate + "]";
	}
	
	
}
