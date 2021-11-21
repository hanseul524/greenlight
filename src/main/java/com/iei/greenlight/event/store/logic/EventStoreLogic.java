package com.iei.greenlight.event.store.logic;

import org.mybatis.spring.SqlSessionTemplate;

import com.iei.greenlight.event.domain.Event;
import com.iei.greenlight.event.store.EventStore;

public class EventStoreLogic implements EventStore{
	
	private SqlSessionTemplate sqlSession;

	@Override
	public int insertEvent(Event event) {
		return sqlSession.insert("eventMapper.insertEvent", event);
	}

}
