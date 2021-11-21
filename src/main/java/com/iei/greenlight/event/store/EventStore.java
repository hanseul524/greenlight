package com.iei.greenlight.event.store;

import java.util.HashMap;
import java.util.List;

import com.iei.greenlight.event.domain.Event;
import com.iei.greenlight.event.domain.EventAnswer;
import com.iei.greenlight.event.domain.EventWinner;

public interface EventStore {
	
	// Event
	public Event selectEventOneByNo(int eventNo);
	public int insertEvent(Event event);
	public int deleteEvent();
	
	// EventAnswer
	public List<EventAnswer> selectEventAnswerList();
	public int selectEventAnswerUserCheck(String userId);
	public int insertEventAnswer(HashMap<String, Object> hashmap);
	public int deleteEventAnswer();
	
	// EventWinner
	public List<EventWinner> selectEventWinnerList();
	public int insertEventWinner(List<EventWinner> wList);
	public int deleteEventWinner();

}
