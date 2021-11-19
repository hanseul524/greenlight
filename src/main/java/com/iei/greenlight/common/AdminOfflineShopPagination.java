package com.iei.greenlight.common;

import com.iei.greenlight.shop.domain.OfflinePageInfo;

public class AdminOfflineShopPagination {

	public static OfflinePageInfo getPageInfo(int currentPage, int totalCount) {

		OfflinePageInfo pi = null;

		int naviLimit = 5; // 한 페이지에서 보여주는 리스트의 갯수
		int offlineLimit = 5; // 한 페이지에서 보여주는 페이지의 범위
		int maxPage; // 마지막 페이지
		int startNavi; // 네비에서 시작하는 페이지 번호
		int endNavi; // 네비에서 끝나는 페이지 번호

		maxPage = (int) ((double) totalCount / offlineLimit + 0.9);
		startNavi = (((int) ((double) currentPage / naviLimit + 0.9)) - 1) * naviLimit + 1;
		endNavi = startNavi + naviLimit - 1;
		if (maxPage < endNavi) {
			endNavi = maxPage;
		}
		pi = new OfflinePageInfo(currentPage, offlineLimit, naviLimit, startNavi, endNavi, totalCount, maxPage);
		return pi;
	}
}
