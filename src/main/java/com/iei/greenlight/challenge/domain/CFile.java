package com.iei.greenlight.challenge.domain;

import java.sql.Date;

public class CFile {
	
	private int chNo;
	private String chWriter;
	private int categoryNo;
	private String filePath;
	private String fileName;
	private long fileSize;
	private Date fileDate;
	private String fileMain;
	
	public CFile() {}
	
	
	public CFile(int chNo, String chWriter, int categoryNo, String filePath, String fileName, long fileSize,
			Date fileDate, String fileMain) {
		super();
		this.chNo = chNo;
		this.chWriter = chWriter;
		this.categoryNo = categoryNo;
		this.filePath = filePath;
		this.fileName = fileName;
		this.fileSize = fileSize;
		this.fileDate = fileDate;
		this.fileMain = fileMain;
	}

	public CFile(String filePath, String fileName) {
		super();
		this.filePath = filePath;
		this.fileName = fileName;
	}

	public int getChNo() {
		return chNo;
	}

	public void setChNo(int chNo) {
		this.chNo = chNo;
	}

	public String getChWriter() {
		return chWriter;
	}

	public void setChWriter(String chWriter) {
		this.chWriter = chWriter;
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

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
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
		return "CFile [글번호=" + chNo + ", 아이디=" + chWriter + ", 카테고리번호=" + categoryNo + ", 파일경로=" + filePath
				+ ", 파일이름=" + fileName + ", 파일사이즈=" + fileSize + ", 업로드날짜=" + fileDate + ", 대표사진여부="
				+ fileMain + "]";
	}
	
}
