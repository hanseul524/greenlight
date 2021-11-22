package com.iei.greenlight.event.domain;

import java.sql.Date;

public class EventWinner {
	
	private int eventNo;
	private String userId;
	private String userName;
	private String paymentsStatus;
	private int point;
	private Date joinDate;
	
	private EventWinner() {}
	
	

	public EventWinner(int eventNo, String userId) {
		super();
		this.eventNo = eventNo;
		this.userId = userId;
	}



	public EventWinner(int eventNo, String userId, Date joinDate) {
		super();
		this.eventNo = eventNo;
		this.userId = userId;
		this.joinDate = joinDate;
	}

	public EventWinner(int eventNo, String userId, String userName, String paymentsStatus, int point, Date joinDate) {
		super();
		this.eventNo = eventNo;
		this.userId = userId;
		this.userName = userName;
		this.paymentsStatus = paymentsStatus;
		this.point = point;
		this.joinDate = joinDate;
	}

	public int getEventNo() {
		return eventNo;
	}

	public void setEventNo(int eventNo) {
		this.eventNo = eventNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPaymentsStatus() {
		return paymentsStatus;
	}

	public void setPaymentsStatus(String paymentsStatus) {
		this.paymentsStatus = paymentsStatus;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	@Override
	public String toString() {
		return "EventWinner [eventNo=" + eventNo + ", userId=" + userId + ", userName=" + userName + ", paymentsStatus="
				+ paymentsStatus + ", point=" + point + ", joinDate=" + joinDate + "]";
	}


}
