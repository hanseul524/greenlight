package com.iei.greenlight.common;

import com.iei.greenlight.challenge.domain.PageInfo;
import com.iei.greenlight.event.domain.EventPageInfo;

public class EventPagination {
	
	public static EventPageInfo getPagination(int currentPage, int totalCount) {
		
		EventPageInfo pi = null;
		
		int naviLimit = 5;
		int eventLimit = 5;
		int maxPage;
		int startNavi;
		int endNavi;
		
		maxPage = (int)((double)totalCount/eventLimit + 0.9);
		startNavi = ((int)((double)currentPage/naviLimit + 0.9) - 1) * naviLimit + 1;
		endNavi = startNavi + naviLimit - 1;
		if(maxPage < endNavi) {
			endNavi = maxPage;
		}
		pi = new EventPageInfo(currentPage, eventLimit, naviLimit, startNavi, endNavi, totalCount, maxPage);
		
		return pi;
	}

}
