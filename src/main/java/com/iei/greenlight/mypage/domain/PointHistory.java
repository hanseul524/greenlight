package com.iei.greenlight.mypage.domain;

import java.sql.Date;

public class PointHistory {

	private String userId;
	private Date pointDate;
	private String pointContents;
	private int pointPayment;
	private int pointUse;
	private int rowNum;

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

	public int getRowNum() {
		return rowNum;
	}

	public void setRowNum(int rowNum) {
		this.rowNum = rowNum;
	}

	public String getUseId() {
		return userId;
	}

	public void setUseId(String userId) {
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

	@Override
	public String toString() {
		return "PointHistory [유저 아이디 =" + userId + ", 포인트 획득 날짜 =" + pointDate + ", 변동 내용 =" + pointContents
				+ ", 지급 날짜 =" + pointPayment + ", 사용 포인트=" + pointUse + "]";
	}

}
