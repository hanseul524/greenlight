package com.iei.greenlight.donationBoard.domain;

import java.sql.Date;

public class DonationReply {

	private int dtReplyNo;
	private int boardNo;
	private String dtReplyContents;
	private String dtReplyUserId;
	private Date dtReplyDate;
	
	public DonationReply() {}

	public DonationReply(int dtReplyNo, int boardNo, String dtReplyContents, String dtReplyUserId, Date dtReplyDate) {
		super();
		this.dtReplyNo = dtReplyNo;
		this.boardNo = boardNo;
		this.dtReplyContents = dtReplyContents;
		this.dtReplyUserId = dtReplyUserId;
		this.dtReplyDate = dtReplyDate;
	}

	public int getDtReplyNo() {
		return dtReplyNo;
	}

	public void setDtReplyNo(int dtReplyNo) {
		this.dtReplyNo = dtReplyNo;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getDtReplyContents() {
		return dtReplyContents;
	}

	public void setDtReplyContents(String dtReplyContents) {
		this.dtReplyContents = dtReplyContents;
	}

	public String getDtReplyUserId() {
		return dtReplyUserId;
	}

	public void setDtReplyUserId(String dtReplyUserId) {
		this.dtReplyUserId = dtReplyUserId;
	}

	public Date getDtReplyDate() {
		return dtReplyDate;
	}

	public void setDtReplyDate(Date dtReplyDate) {
		this.dtReplyDate = dtReplyDate;
	}

	@Override
	public String toString() {
		return "DonationReply [dtReplyNo=" + dtReplyNo + ", boardNo=" + boardNo + ", dtReplyContents=" + dtReplyContents
				+ ", dtReplyUserId=" + dtReplyUserId + ", dtReplyDate=" + dtReplyDate + "]";
	}
	
}
