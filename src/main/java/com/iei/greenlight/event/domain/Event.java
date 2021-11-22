package com.iei.greenlight.event.domain;

public class Event {
	
	private int eventNo;
	private int rowNum;
	private String eventStart;
	private String eventEnd;
	private int eventPoint;
	private String eventQuestion;
	private String eventAnswer;
	
	public Event() {}

	public Event(int eventNo, int rowNum, String eventStart, String eventEnd, int eventPoint, String eventQuestion,
			String eventAnswer) {
		super();
		this.eventNo = eventNo;
		this.rowNum = rowNum;
		this.eventStart = eventStart;
		this.eventEnd = eventEnd;
		this.eventPoint = eventPoint;
		this.eventQuestion = eventQuestion;
		this.eventAnswer = eventAnswer;
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

	public String getEventStart() {
		return eventStart;
	}

	public void setEventStart(String eventStart) {
		this.eventStart = eventStart;
	}

	public String getEventEnd() {
		return eventEnd;
	}

	public void setEventEnd(String eventEnd) {
		this.eventEnd = eventEnd;
	}

	public int getEventPoint() {
		return eventPoint;
	}

	public void setEventPoint(int eventPoint) {
		this.eventPoint = eventPoint;
	}

	public String getEventQuestion() {
		return eventQuestion;
	}

	public void setEventQuestion(String eventQuestion) {
		this.eventQuestion = eventQuestion;
	}

	public String getEventAnswer() {
		return eventAnswer;
	}

	public void setEventAnswer(String eventAnswer) {
		this.eventAnswer = eventAnswer;
	}

	@Override
	public String toString() {
		return "Event [eventNo=" + eventNo + ", rowNum=" + rowNum + ", eventStart=" + eventStart + ", eventEnd="
				+ eventEnd + ", eventPoint=" + eventPoint + ", eventQuestion=" + eventQuestion + ", eventAnswer="
				+ eventAnswer + "]";
	}

}
