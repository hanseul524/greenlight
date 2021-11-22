package com.iei.greenlight.event.domain;

import java.sql.Date;

public class EventAnswer {
	
	private int eventNo;
	private int rowNum;
	private String userId;
	private Date joinDate;
	private String userName;
	private int point;
	
	public EventAnswer() {}

	public EventAnswer(int eventNo, int rowNum, String userId, Date joinDate, String userName, int point) {
		super();
		this.eventNo = eventNo;
		this.rowNum = rowNum;
		this.userId = userId;
		this.joinDate = joinDate;
		this.userName = userName;
		this.point = point;
	}

	public int getEventNo() {
		return eventNo;
	}

	public void setEventNo(int eventNo) {
		this.eventNo = eventNo;
	}

	public int getRowNum() {
		return rowNum;
	}

	public void setRowNum(int rowNum) {
		this.rowNum = rowNum;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	@Override
	public String toString() {
		return "EventAnswer [eventNo=" + eventNo + ", rowNum=" + rowNum + ", userId=" + userId + ", joinDate="
				+ joinDate + ", userName=" + userName + ", point=" + point + "]";
	}

}
