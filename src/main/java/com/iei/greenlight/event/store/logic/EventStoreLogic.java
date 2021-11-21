package com.iei.greenlight.event.store.logic;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.iei.greenlight.event.domain.Event;
import com.iei.greenlight.event.domain.EventAnswer;
import com.iei.greenlight.event.domain.EventWinner;
import com.iei.greenlight.event.store.EventStore;

public class EventStoreLogic implements EventStore{
	
	private SqlSessionTemplate sqlSession;

	@Override
	public Event selectEventOneByNo(int eventNo) {
		return sqlSession.selectOne("eventMapper.selectEventOneByNo", eventNo);
	}
	
	@Override
	public int insertEvent(Event event) {
		return sqlSession.insert("eventMapper.insertEvent", event);
	}

	@Override
	public int deleteEvent() {
		return sqlSession.delete("eventMapper.deleteEvent");
	}

	@Override
	public List<EventAnswer> selectEventAnswerList() {
		return sqlSession.selectList("eventMapper.selectEventAnswerList");
	}
	
	@Override
	public int selectEventAnswerUserCheck(String userId) {
		return sqlSession.selectOne("eventMapper.selectEventAnswerUserCheck", userId);
	}
	
	@Override
	public int insertEventAnswer(HashMap<String, Object> hashmap) {
		return sqlSession.insert("eventMapper.insertEventAnswer", hashmap);
	}
	
	@Override
	public int deleteEventAnswer() {
		return sqlSession.delete("eventMapper.deleteEventAnswer");
	}
	
	@Override
	public List<EventWinner> selectEventWinnerList() {
		return sqlSession.selectList("eventMapper.selectEventWinnerList");
	}

	@Override
	public int insertEventWinner(List<EventWinner> wList) {
		return sqlSession.insert("eventMapper.insertEventWinner", wList);
	}

	@Override
	public int deleteEventWinner() {
		return sqlSession.delete("eventMapper.deleteEventWinner");
	}


}
