package com.iei.greenlight.event.domain;

import java.sql.Date;

public class EventAnswer {
	
	private int eventNo;
	private String userId;
	private Date joinDate;
	
	public EventAnswer() {}
	
	public EventAnswer(int eventNo, String userId, Date joinDate) {
		super();
		this.eventNo = eventNo;
		this.userId = userId;
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
	
	public Date getJoinDate() {
		return joinDate;
	}
	
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	
	@Override
	public String toString() {
		return "EventAnswer [eventNo=" + eventNo + ", userId=" + userId + ", joinDate=" + joinDate + "]";
	}
	
	

}
