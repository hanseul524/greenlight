package com.iei.greenlight.chargePoint.domain;

import java.sql.Date;

public class ChargePoint {

	private int chargeNo;
	private String userId;
	private int chargeMoney;
	private int chargePoint;
	private Date chargeDate;
	private String impUid;
	private String refund;
	private int rowNum;

	public ChargePoint() {}
	
	public ChargePoint(int chargeNo, String userId, int chargeMoney, int chargePoint, Date chargeDate, String impUid,
			String refund, int rowNum) {
		super();
		this.chargeNo = chargeNo;
		this.userId = userId;
		this.chargeMoney = chargeMoney;
		this.chargePoint = chargePoint;
		this.chargeDate = chargeDate;
		this.impUid = impUid;
		this.refund = refund;
		this.rowNum = rowNum;
	}

	public String getImpUid() {
		return impUid;
	}

	public void setImpUid(String impUid) {
		this.impUid = impUid;
	}

	public int getRowNum() {
		return rowNum;
	}

	public void setRowNum(int rowNum) {
		this.rowNum = rowNum;
	}

	public int getChargeNo() {
		return chargeNo;
	}

	public void setChargeNo(int chargeNo) {
		this.chargeNo = chargeNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getChargeMoney() {
		return chargeMoney;
	}

	public void setChargeMoney(int chargeMoney) {
		this.chargeMoney = chargeMoney;
	}

	public int getChargePoint() {
		return chargePoint;
	}

	public void setChargePoint(int chargePoint) {
		this.chargePoint = chargePoint;
	}

	public Date getChargeDate() {
		return chargeDate;
	}

	public void setChargeDate(Date chargeDate) {
		this.chargeDate = chargeDate;
	}

	public String getRefund() {
		return refund;
	}

	public void setRefund(String refund) {
		this.refund = refund;
	}

	@Override
	public String toString() {
		return "ChargePoint [chargeNo=" + chargeNo + ", userId=" + userId + ", chargeMoney=" + chargeMoney
				+ ", chargePoint=" + chargePoint + ", chargeDate=" + chargeDate + ", impUid=" + impUid + ", refund="
				+ refund + ", rowNum=" + rowNum + "]";
	}

	

}
