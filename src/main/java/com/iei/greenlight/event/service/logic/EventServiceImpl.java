package com.iei.greenlight.event.service.logic;

import java.util.HashMap;
import java.util.List;

import com.iei.greenlight.event.domain.Event;
import com.iei.greenlight.event.domain.EventAnswer;
import com.iei.greenlight.event.domain.EventWinner;
import com.iei.greenlight.event.service.EventService;
import com.iei.greenlight.event.store.EventStore;

public class EventServiceImpl implements EventService{
	
	private EventStore store;

	@Override
	public Event printEventOneByNo(int eventNo) {
		return store.selectEventOneByNo(eventNo);
	}
	
	@Override
	public int registerEvent(Event event) {
		return store.insertEvent(event);
	}
	
	@Override
	public int removeEvent() {
		return store.deleteEvent();
	}

	@Override
	public List<EventAnswer> printEventAnswerList() {
		return store.selectEventAnswerList();
	}
	
	@Override
	public int printEventAnswerUserCheck(String userId) {
		return store.selectEventAnswerUserCheck(userId);
	}
	
	@Override
	public int registerEventAnswer(HashMap<String, Object> hashmap) {
		return store.insertEventAnswer(hashmap);
	}

	@Override
	public int removeEventAnswer() {
		return store.deleteEventAnswer();
	}
	
	@Override
	public List<EventWinner> printEventWinnerList() {
		return store.selectEventWinnerList();
	}
	
	@Override
	public int registerEventWinner(List<EventWinner> wList) {
		return store.insertEventWinner(wList);
	}

	@Override
	public int removeEventWinner() {
		return store.deleteEventWinner();
	}




}
