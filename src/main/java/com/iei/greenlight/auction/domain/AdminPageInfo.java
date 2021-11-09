package com.iei.greenlight.auction.domain;

public class AdminPageInfo {
	
	private int currentPage;
	private int auctionLimit;
	private int naviLimit;
	private int startNavi;
	private int endNavi;
	private int totalCount;
	private int maxPage;
	
	public AdminPageInfo() {}

	public AdminPageInfo(int currentPage, int auctionLimit, int naviLimit, int startNavi, int endNavi, int totalCount,
			int maxPage) {
		super();
		this.currentPage = currentPage;
		this.auctionLimit = auctionLimit;
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

	public int getAuctionLimit() {
		return auctionLimit;
	}

	public void setAuctionLimit(int auctionLimit) {
		this.auctionLimit = auctionLimit;
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
		return "PageInfo [currentPage=" + currentPage + ", auctionLimit=" + auctionLimit + ", naviLimit=" + naviLimit
				+ ", startNavi=" + startNavi + ", endNavi=" + endNavi + ", totalCount=" + totalCount + ", maxPage="
				+ maxPage + "]";
	}

}
