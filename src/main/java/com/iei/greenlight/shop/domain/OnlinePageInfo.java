package com.iei.greenlight.shop.domain;

public class OnlinePageInfo {
	
	private int currentPage;
	private int onlineShopLimit;
	private int naviLimit;
	private int startNavi;
	private int endNavi;
	private int totalCount;
	private int maxPage;
	
	public OnlinePageInfo() {}

	public OnlinePageInfo(int currentPage, int onlineShopLimit, int naviLimit, int startNavi, int endNavi,
			int totalCount, int maxPage) {
		super();
		this.currentPage = currentPage;
		this.onlineShopLimit = onlineShopLimit;
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

	public int getOnlineShopLimit() {
		return onlineShopLimit;
	}

	public void setOnlineShopLimit(int onlineShopLimit) {
		this.onlineShopLimit = onlineShopLimit;
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
		return "OnlinePageInfo [currentPage=" + currentPage + ", onlineShopLimit=" + onlineShopLimit + ", naviLimit="
				+ naviLimit + ", startNavi=" + startNavi + ", endNavi=" + endNavi + ", totalCount=" + totalCount
				+ ", maxPage=" + maxPage + "]";
	}
	
	

}
