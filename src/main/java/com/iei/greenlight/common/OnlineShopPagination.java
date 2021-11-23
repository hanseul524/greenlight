package com.iei.greenlight.common;

import com.iei.greenlight.auction.domain.AdminPageInfo;
import com.iei.greenlight.shop.domain.OnlinePageInfo;

public class OnlineShopPagination {
	
	public static OnlinePageInfo getPageInfo(int currentPage, int totalCount) {
		
		OnlinePageInfo pi = null;
		
		int naviLimit = 5;  // 한 페이지에 보이는 네비갯수
		int onlineShopLimit = 6; // 한 페이지에서 보이는 글 갯수
		int maxPage;        // 전체 페이지에서 제일 마지막 페이지
		int startNavi;      // 시작페이지 번호
		int endNavi;        // 끝 페이지 번호
		
		maxPage = (int)((double)totalCount/onlineShopLimit + 0.9);
		startNavi = ((int)((double)currentPage/naviLimit + 0.9) - 1) * naviLimit + 1;
		endNavi = startNavi + naviLimit - 1;
		if(maxPage < endNavi) {
			endNavi = maxPage;
		}
		
		pi = new OnlinePageInfo(currentPage, onlineShopLimit, naviLimit, startNavi, endNavi, totalCount, maxPage);
		
		return pi;
		
	}

}
