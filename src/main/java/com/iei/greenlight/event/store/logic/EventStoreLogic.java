package com.iei.greenlight.event.store.logic;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iei.greenlight.event.domain.Event;
import com.iei.greenlight.event.domain.EventAnswer;
import com.iei.greenlight.event.domain.EventPageInfo;
import com.iei.greenlight.event.domain.EventWinner;
import com.iei.greenlight.event.store.EventStore;

@Repository
public class EventStoreLogic implements EventStore{
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public Event selectEvent() {
		return sqlSession.selectOne("eventMapper.selectEvent");
	}

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
	public List<EventAnswer> selectEventAnswerList(EventPageInfo pi) {
		int offset = (pi.getCurrentPage() - 1) * pi.getEventLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getEventLimit());
		return sqlSession.selectList("eventMapper.adminEventAnswerList", pi, rowBounds);
	}
	
	@Override
	public List<EventAnswer> selectEventAnswerList() {
		return sqlSession.selectList("eventMapper.selectEventAnswerList");
	}
	
	@Override
	public int selectEventAnswerListCount() {
		return sqlSession.selectOne("eventMapper.selectEventAnswerListCount");
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
	public List<EventWinner> selectEventWinnerList(EventPageInfo pi) {
		int offset = (pi.getCurrentPage() - 1) * pi.getEventLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getEventLimit());
		return sqlSession.selectList("eventMapper.adminEventWinnerList", pi, rowBounds);
	}
	
	@Override
	public List<EventWinner> selectEventWinnerList() {
		return sqlSession.selectList("eventMapper.adminEventWinnerList");
	}
	
	@Override
	public List<EventWinner> selectEventWinner() {
		return sqlSession.selectList("eventMapper.eventWinnerList");
	}
	
	@Override
	public int selectEventWinnerListCount() {
		return sqlSession.selectOne("eventMapper.selectEventWinnerListCount");
	}
	
	@Override
	public int selectEventCheckUserId(String userId) {
		return sqlSession.selectOne("eventMapper.selectEventCheckUserId", userId);
	}

	@Override
	public int insertEventWinner(List<EventWinner> wList) {
		return sqlSession.insert("eventMapper.insertEventWinner", wList);
	}
	
	@Override
	public int updateEventWinner(String [] userId) {
		return sqlSession.update("eventMapper.updateEventWinnerPaymentsStatus", userId);
	}

	@Override
	public int deleteEventWinner() {
		return sqlSession.delete("eventMapper.deleteEventWinner");
	}




}
