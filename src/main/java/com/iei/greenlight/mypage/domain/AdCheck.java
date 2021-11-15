package com.iei.greenlight.mypage.domain;

import java.sql.Date;

public class AdCheck {

	private String userId;
	private Date adDate;
	private int consecutive;
	
	public AdCheck() {
		
	}
	
	public AdCheck(String userId, Date adDate, int consecutive) {
		super();
		this.userId = userId;
		this.adDate = adDate;
		this.consecutive = consecutive;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getAdDate() {
		return adDate;
	}

	public void setAdDate(Date adDate) {
		this.adDate = adDate;
	}

	public int getConsecutive() {
		return consecutive;
	}

	public void setConsecutive(int consecutive) {
		this.consecutive = consecutive;
	}

	@Override
	public String toString() {
		return "AdCheck [userId=" + userId + ", adDate=" + adDate + ", consecutive=" + consecutive + "]";
	}
}
