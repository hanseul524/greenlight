package com.iei.greenlight.event.service;

import java.util.HashMap;
import java.util.List;

import com.iei.greenlight.event.domain.Event;
import com.iei.greenlight.event.domain.EventAnswer;
import com.iei.greenlight.event.domain.EventPageInfo;
import com.iei.greenlight.event.domain.EventWinner;

public interface EventService {
	
	// Event
	public Event printEvent();
	public Event printEventOneByNo(int eventNo);
	public int registerEvent(Event event);
	public int removeEvent();

	// EventAnswer
	public List<EventAnswer> printEventAnswerList(EventPageInfo pi);
	public List<EventAnswer> printEventAnswerList();
	public int getEventAnswerListCount();
	public int printEventAnswerUserCheck(String userId);
	public int registerEventAnswer(HashMap<String, Object> hashmap);
	public int removeEventAnswer();
	
	// EventWinner
	public List<EventWinner> printEventWinnerList(EventPageInfo pi);
	public List<EventWinner> printEventWinnerList();
	public List<EventWinner> printEventWinner();
	public int getEventWinnerListCount();
	public int printEventCheckUserId(String userId);
	public int registerEventWinner(List<EventWinner> wList);
	public int modifyEventWinner(String[] userId);
	public int removeEventWinner();
}
