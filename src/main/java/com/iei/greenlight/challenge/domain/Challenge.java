package com.iei.greenlight.challenge.domain;

import java.sql.Date;
import java.util.List;

public class Challenge {
	
	private int categoryNo;
	private int chNo;
	private String chWriter;
	private String chTitle;
	private String chContents;
	private Date writeDate;
	private int likeCount;
	private int replyCount;
	private String chConfirm;
	private String fileName;
	private String filePath;
	private String fileMain;
	
//	private List<CFile> cfList; 
	
	public Challenge() {}
	
//	public List<CFile> getcfList() {
//		return cfList;
//	}
//
//	public void setcfList(List<CFile> cfList) {
//		this.cfList = cfList;
//	}
	
	
	public int getCategoryNo() {
		return categoryNo;
	}

	public Challenge(int categoryNo, int chNo, String chWriter, String chTitle, String chContents, Date writeDate,
			int likeCount, int replyCount, String chConfirm, String fileName, String filePath, String fileMain) {
		super();
		this.categoryNo = categoryNo;
		this.chNo = chNo;
		this.chWriter = chWriter;
		this.chTitle = chTitle;
		this.chContents = chContents;
		this.writeDate = writeDate;
		this.likeCount = likeCount;
		this.replyCount = replyCount;
		this.chConfirm = chConfirm;
		this.fileName = fileName;
		this.filePath = filePath;
		this.fileMain = fileMain;
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

	public void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
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

	public String getChTitle() {
		return chTitle;
	}

	public void setChTitle(String chTitle) {
		this.chTitle = chTitle;
	}

	public String getChContents() {
		return chContents;
	}

	public void setChContents(String chContents) {
		this.chContents = chContents;
	}

	public Date getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}

	public int getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}

	public int getReplyCount() {
		return replyCount;
	}

	public void setReplyCount(int replyCount) {
		this.replyCount = replyCount;
	}

	public String getChConfirm() {
		return chConfirm;
	}

	public void setChConfirm(String chConfirm) {
		this.chConfirm = chConfirm;
	}

	@Override
	public String toString() {
		return "Challenge [카테고리 번호=" + categoryNo + ", 글번호=" + chNo + ", 작성자아이디=" + chWriter + ", 글제목="
				+ chTitle + ", 글내용=" + chContents + ", 작성일=" + writeDate + ", 좋아요수=" + likeCount
				+ ", 댓글수=" + replyCount + ", 인증유무=" + chConfirm + ", 파일이름=" + fileName + ", 파일경로="
				+ filePath + ", 대표사진=" + fileMain + "]";
	}


	
}
