package com.iei.greenlight.event.service.logic;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iei.greenlight.event.domain.Event;
import com.iei.greenlight.event.domain.EventAnswer;
import com.iei.greenlight.event.domain.EventPageInfo;
import com.iei.greenlight.event.domain.EventWinner;
import com.iei.greenlight.event.service.EventService;
import com.iei.greenlight.event.store.EventStore;

@Service
public class EventServiceImpl implements EventService{
	
	@Autowired
	private EventStore store;
	
	@Override
	public Event printEvent() {
		return store.selectEvent();
	}

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
	public List<EventAnswer> printEventAnswerList(EventPageInfo pi) {
		return store.selectEventAnswerList(pi);
	}
	
	@Override
	public List<EventAnswer> printEventAnswerList() {
		return store.selectEventAnswerList();
	}
	
	@Override
	public int getEventAnswerListCount() {
		return store.selectEventAnswerListCount();
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
	public List<EventWinner> printEventWinnerList(EventPageInfo pi) {
		return store.selectEventWinnerList(pi);
	}
	
	@Override
	public List<EventWinner> printEventWinnerList() {
		return store.selectEventWinnerList();
	}
	
	@Override
	public List<EventWinner> printEventWinner() {
		return store.selectEventWinner();
	}
	
	@Override
	public int getEventWinnerListCount() {
		return store.selectEventWinnerListCount();
	}
	
	@Override
	public int printEventCheckUserId(String userId) {
		return store.selectEventCheckUserId(userId);
	}
	
	@Override
	public int registerEventWinner(List<EventWinner> wList) {
		return store.insertEventWinner(wList);
	}

	@Override
	public int modifyEventWinner(String [] userId) {
		return store.updateEventWinner(userId);
	}
	
	@Override
	public int removeEventWinner() {
		return store.deleteEventWinner();
	}






}
