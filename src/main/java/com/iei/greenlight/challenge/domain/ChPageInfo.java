package com.iei.greenlight.challenge.domain;

public class ChPageInfo {
	
	private int currentPage;
	private int boardLimit;
	private int naviLimit;
	private int startNavi;
	private int endNavi;
	private int totalCount;
	private int maxPage;
	
	public ChPageInfo() {}

	public ChPageInfo(int currentPage, int boardLimit, int naviLimit, int startNavi, int endNavi, int totalCount,
			int maxPage) {
		super();
		this.currentPage = currentPage;
		this.boardLimit = boardLimit;
		this.naviLimit = naviLimit;
		this.startNavi = startNavi;
		this.endNavi = endNavi;
		this.totalCount = totalCount;
		this.maxPage = maxPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getBoardLimit() {
		return boardLimit;
	}

	public void setBoardLimit(int boardLimit) {
		this.boardLimit = boardLimit;
	}

	public int getNaviLimit() {
		return naviLimit;
	}

	public void setNaviLimit(int naviLimit) {
		this.naviLimit = naviLimit;
	}

	public int getStartNavi() {
		return startNavi;
	}

	public void setStartNavi(int startNavi) {
		this.startNavi = startNavi;
	}

	public int getEndNavi() {
		return endNavi;
	}

	public void setEndNavi(int endNavi) {
		this.endNavi = endNavi;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getMaxPage() {
		return maxPage;
	}

	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}

	@Override
	public String toString() {
		return "ChPageinfo [현재 페이지=" + currentPage + ", 게시글 갯수=" + boardLimit + ", 네비 갯수=" + naviLimit
				+ ", 네비 시작=" + startNavi + ", 네비끝=" + endNavi + ", 전체 글 갯수=" + totalCount + ", 최대 페이지="
				+ maxPage + "]";
	}
	
}
