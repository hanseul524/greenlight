package com.iei.greenlight.event.service;

import java.util.HashMap;
import java.util.List;

import com.iei.greenlight.event.domain.Event;
import com.iei.greenlight.event.domain.EventAnswer;
import com.iei.greenlight.event.domain.EventWinner;

public interface EventService {
	
	// Event
	public Event printEventOneByNo(int eventNo);
	public int registerEvent(Event event);
	public int removeEvent();

	// EventAnswer
	public List<EventAnswer> printEventAnswerList();
	public int printEventAnswerUserCheck(String userId);
	public int registerEventAnswer(HashMap<String, Object> hashmap);
	public int removeEventAnswer();
	
	// EventWinner
	public List<EventWinner> printEventWinnerList();
	public int registerEventWinner(List<EventWinner> wList);
	public int removeEventWinner();
}
