package com.iei.greenlight.challenge.domain;

import java.sql.Date;

public class Reply {
	private int replyNo;
	private int refChNo;
	private String replywriter;
	private String replyContents;
	private Date replyDate;
	
	public Reply() {}
	
		
	public Reply(int replyNo, int refChNo, String replywriter, String replyContents, Date replyDate) {
		super();
		this.replyNo = replyNo;
		this.refChNo = refChNo;
		this.replywriter = replywriter;
		this.replyContents = replyContents;
		this.replyDate = replyDate;
	}

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
		return "Reply [댓글 번호=" + replyNo + ", 글 번호=" + refChNo + ", 댓글 작성자=" + replywriter
				+ ", 댓글 내용=" + replyContents + ", 댓글 작성일=" + replyDate + "]";
	}
	
	
}
