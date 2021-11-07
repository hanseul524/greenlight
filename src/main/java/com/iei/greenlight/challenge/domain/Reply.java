package com.iei.greenlight.challenge.domain;

import java.sql.Date;

public class Reply {
	private int replyNo;
	private int refChNo;
	private String replywriter;
	private int refCategoryNo;
	private String replyContents;
	private Date replyDate;
	
	public Reply() {}

	public int getReplyNo() {
		return replyNo;
	}

	public void setReplyNo(int replyNo) {
		this.replyNo = replyNo;
	}

	public int getRefChNo() {
		return refChNo;
	}

	public void setRefChNo(int refChNo) {
		this.refChNo = refChNo;
	}

	public String getReplywriter() {
		return replywriter;
	}

	public void setReplywriter(String replywriter) {
		this.replywriter = replywriter;
	}

	public int getRefCategoryNo() {
		return refCategoryNo;
	}

	public void setRefCategoryNo(int refCategoryNo) {
		this.refCategoryNo = refCategoryNo;
	}

	public String getReplyContents() {
		return replyContents;
	}

	public void setReplyContents(String replyContents) {
		this.replyContents = replyContents;
	}

	public Date getReplyDate() {
		return replyDate;
	}

	public void setReplyDate(Date replyDate) {
		this.replyDate = replyDate;
	}

	@Override
	public String toString() {
		return "Reply [댓글번호=" + replyNo + ", 글번호=" + refChNo + ", 댓글작성자=" + replywriter
				+ ", 카테고리번호=" + refCategoryNo + ", 댓글내용=" + replyContents + ", 댓글작성일=" + replyDate
				+ "]";
	}
	
}
