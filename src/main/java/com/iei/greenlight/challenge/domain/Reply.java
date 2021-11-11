package com.iei.greenlight.challenge.domain;

import java.sql.Date;

public class Reply {
	private int replyNo;
	private int chNo;
	private String replywriter;
	private String replyContents;
	private Date replyDate;
	
	public Reply() {}
	
	
	public Reply(int replyNo, int chNo, String replywriter, String replyContents, Date replyDate) {
		super();
		this.replyNo = replyNo;
		this.chNo = chNo;
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

	public int getChNo() {
		return chNo;
	}

	public void setChNo(int chNo) {
		this.chNo = chNo;
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
		return "Reply [댓글 번호=" + replyNo + ", 글 번호=" + chNo + ", 댓글 작성자=" + replywriter + ", 댓글 내용="
				+ replyContents + ", 댓글 작성일=" + replyDate + "]";
	}
	
}
