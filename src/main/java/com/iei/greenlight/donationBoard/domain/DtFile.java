package com.iei.greenlight.donationBoard.domain;

import java.sql.Date;

public class DtFile {

	private int boardNo;
	private String fileName;
	private String filePath;
	private long fileSize;
	private Date uploadDate;
	private String fileMain;
	
	public DtFile() {}

	

	public DtFile(int boardNo, String fileName, String filePath, long fileSize, Date uploadDate, String fileMain) {
		super();
		this.boardNo = boardNo;
		this.fileName = fileName;
		this.filePath = filePath;
		this.fileSize = fileSize;
		this.uploadDate = uploadDate;
		this.fileMain = fileMain;
	}



	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
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

	
	public String getFileMain() {
		return fileMain;
	}



	public void setFileMain(String fileMain) {
		this.fileMain = fileMain;
	}



	@Override
	public String toString() {
		return "DtFile [boardNo=" + boardNo + ", fileName=" + fileName + ", filePath=" + filePath + ", fileSize="
				+ fileSize + ", uploadDate=" + uploadDate + ", fileMain=" + fileMain + "]";
	}
	
}
