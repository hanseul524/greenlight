package com.iei.greenlight.mypage.domain;

import java.sql.Date;

public class PointHistory {

	private String userId;
	private Date pointDate;
	private String pointContents;
	private int pointPayment;
	private int pointUse;
	private String chargeYN;
	
	public PointHistory() {
	}

	public PointHistory(String userId, Date pointDate, String pointContents, int pointPayment, int pointUse) {
		super();
		this.userId = userId;
		this.pointDate = pointDate;
		this.pointContents = pointContents;
		this.pointPayment = pointPayment;
		this.pointUse = pointUse;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getPointDate() {
		return pointDate;
	}

	public void setPointDate(Date pointDate) {
		this.pointDate = pointDate;
	}

	public String getPointContents() {
		return pointContents;
	}

	public void setPointContents(String pointContents) {
		this.pointContents = pointContents;
	}

	public int getPointPayment() {
		return pointPayment;
	}

	public void setPointPayment(int pointPayment) {
		this.pointPayment = pointPayment;
	}

	public int getPointUse() {
		return pointUse;
	}

	public void setPointUse(int pointUse) {
		this.pointUse = pointUse;
	}
	
	

	public String getChargeYN() {
		return chargeYN;
	}

	public void setChargeYN(String chargeYN) {
		this.chargeYN = chargeYN;
	}

	@Override
	public String toString() {
		return "PointHistory [userId=" + userId + ", pointDate=" + pointDate + ", pointContents=" + pointContents
				+ ", pointPayment=" + pointPayment + ", pointUse=" + pointUse + ", chargeYN=" + chargeYN + "]";
	}


}
