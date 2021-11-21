package com.iei.greenlight.event.store;

import com.iei.greenlight.event.domain.Event;

public interface EventStore {
	
	public int insertEvent(Event event);

}
