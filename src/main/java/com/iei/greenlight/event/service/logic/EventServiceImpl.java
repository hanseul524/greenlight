package com.iei.greenlight.event.service.logic;

import com.iei.greenlight.event.domain.Event;
import com.iei.greenlight.event.service.EventService;
import com.iei.greenlight.event.store.EventStore;

public class EventServiceImpl implements EventService{
	
	private EventStore store;

	@Override
	public int registerEvent(Event event) {
		return store.insertEvent(event);
	}

}
