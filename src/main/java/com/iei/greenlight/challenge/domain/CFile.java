package com.iei.greenlight.challenge.domain;

import java.sql.Date;

public class CFile {
	
	private int chNo;
	private String userId;
	private int categoryNo;
	private String filePath;
	private String fileName;
	private String fileSize;
	private Date fileDate;
	private String fileMain;
	
	public CFile() {}

	public int getChNo() {
		return chNo;
	}

	public void setChNo(int chNo) {
		this.chNo = chNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getCategoryNo() {
		return categoryNo;
	}

	public void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileSize() {
		return fileSize;
	}

	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}

	public Date getFileDate() {
		return fileDate;
	}

	public void setFileDate(Date fileDate) {
		this.fileDate = fileDate;
	}

	public String getFileMain() {
		return fileMain;
	}

	public void setFileMain(String fileMain) {
		this.fileMain = fileMain;
	}

	@Override
	public String toString() {
		return "CFile [글번호=" + chNo + ", 아이디=" + userId + ", 카테고리번호=" + categoryNo + ", 파일경로=" + filePath
				+ ", 파일이름=" + fileName + ", 파일사이즈=" + fileSize + ", 업로드날짜=" + fileDate + ", 대표사진여부="
				+ fileMain + "]";
	}
	
}
