package com.iei.greenlight.chargePoint.common;

import com.iei.greenlight.chargePoint.domain.PageInfo;

public class Pagination {

	public static PageInfo getPageInfo(int currentPage, int totalCount) {
	      PageInfo pi = null;
	      int naviLimit = 5; // 한 페이지에 나오는 페이지 수
	      int boardLimit = 5; // 한 페이지에 나오는 게시글 수
	      int maxPage; 		  // 마지막 페이지 숫자
	      int startNavi;	  // 시작 페이지 숫자
	      int endNavi;		  // 한 페이지에서 마지막 페이지 숫자
	      maxPage = (int)((double)totalCount/boardLimit + 0.9);
	      startNavi = (((int)((double)currentPage/naviLimit + 0.9)) -1) * naviLimit + 1;
	      endNavi = startNavi + naviLimit - 1;
	      if(maxPage < endNavi) {
	         endNavi = maxPage;
	      }
	      pi = new PageInfo(currentPage, boardLimit, naviLimit, startNavi, endNavi, totalCount, maxPage);
	      return pi;
	   }
}
