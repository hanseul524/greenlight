package com.iei.greenlight.donationBoard.domain;

import java.sql.Date;

public class Donation {
	
	private int boardNo;
	private String userId;
	private int donationPoint;
	private Date donationDate;
	
	public Donation() {}

	public Donation(int boardNo, String userId, int donationPoint, Date donationDate) {
		super();
		this.boardNo = boardNo;
		this.userId = userId;
		this.donationPoint = donationPoint;
		this.donationDate = donationDate;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getDonationPoint() {
		return donationPoint;
	}

	public void setDonationPoint(int donationPoint) {
		this.donationPoint = donationPoint;
	}

	public Date getDonationDate() {
		return donationDate;
	}

	public void setDonationDate(Date donationDate) {
		this.donationDate = donationDate;
	}

	@Override
	public String toString() {
		return "Donation [boardNo=" + boardNo + ", userId=" + userId + ", donationPoint=" + donationPoint
				+ ", donationDate=" + donationDate + "]";
	}
	
}
