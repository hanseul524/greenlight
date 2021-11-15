package com.iei.greenlight.donationBoard.domain;

import java.sql.Date;

public class DonationBoard {
	
	private int boardNo;
	private String dtSubject;
	private String dtContents;
	private int dtReplyCount;
	private int dtTargetAmount;
	private int donationAmount;
	private char dtSuccess;
	private Date writeDate;
	
	public DonationBoard() {}

	public DonationBoard(int boardNo, String dtSubject, String dtContents, int dtReplyCount,
			int dtTargetAmount, int donationAmount, char dtSuccess, Date writeDate) {
		super();
		this.boardNo = boardNo;
		this.dtSubject = dtSubject;
		this.dtContents = dtContents;
		this.dtReplyCount = dtReplyCount;
		this.dtTargetAmount = dtTargetAmount;
		this.donationAmount = donationAmount;
		this.dtSuccess = dtSuccess;
		this.writeDate = writeDate;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getDtSubject() {
		return dtSubject;
	}

	public void setDtSubject(String dtSubject) {
		this.dtSubject = dtSubject;
	}

	public String getDtContents() {
		return dtContents;
	}

	public void setDtContents(String dtContents) {
		this.dtContents = dtContents;
	}

	public int getDtReplyCount() {
		return dtReplyCount;
	}

	public void setDtReplyCount(int dtReplyCount) {
		this.dtReplyCount = dtReplyCount;
	}

	public int getDtTargetAmount() {
		return dtTargetAmount;
	}

	public void setDtTargetAmount(int dtTargetAmount) {
		this.dtTargetAmount = dtTargetAmount;
	}

	public int getDonationAmount() {
		return donationAmount;
	}

	public void setDonationAmount(int donationAmount) {
		this.donationAmount = donationAmount;
	}

	public char getDtSuccess() {
		return dtSuccess;
	}

	public void setDtSuccess(char dtSuccess) {
		this.dtSuccess = dtSuccess;
	}

	public Date getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}

	@Override
	public String toString() {
		return "DonationBoard [boardNo=" + boardNo + ", dtSubject=" + dtSubject + ", dtContents=" + dtContents
				+ ", dtReplyCount=" + dtReplyCount + ", dtTargetAmount=" + dtTargetAmount
				+ ", donationAmount=" + donationAmount + ", dtSuccess=" + dtSuccess + ", writeDate=" + writeDate + "]";
	}
	
}
