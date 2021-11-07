package com.iei.greenlight.challenge.domain;

import java.sql.Date;

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
	
	public Challenge() {}

	public int getCategoryNo() {
		return categoryNo;
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
		return "Challenge [카테고리번호=" + categoryNo + ", 글번호=" + chNo + ", 작성자아이디=" + chWriter + ", 글제목="
				+ chTitle + ", 글내용=" + chContents + ", 작성일=" + writeDate + ", 좋아요수=" + likeCount
				+ ", 댓글수=" + replyCount + ", 인증유무=" + chConfirm + "]";
	}
	
}
