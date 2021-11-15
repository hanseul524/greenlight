package com.iei.greenlight.common;

import com.iei.greenlight.user.domain.PageInfo;

public class UserPagination {
	
	public static PageInfo getpageInfo(int currentPage, int totalCount) {
		
		PageInfo upi = null;
		
		int naviLimit = 5;
		int boardLimit = 5;
		int maxPage;
		int startNavi;
		int endNavi;
		
		maxPage = (int)((double)totalCount/boardLimit + 0.9);
		startNavi = ((int)((double)currentPage/naviLimit + 0.9) - 1) * naviLimit + 1;
		endNavi = startNavi + naviLimit - 1;
		if(maxPage < endNavi) {
			endNavi = maxPage;
		}
		upi = new PageInfo(currentPage, boardLimit, naviLimit, startNavi, endNavi, totalCount, maxPage);
		
		return upi;
	}

}
