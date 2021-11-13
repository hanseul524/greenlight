package com.iei.greenlight.shop.domain;

public class OnlineShop {
	
	private int shopNo;
	private String shopName;
	private String shopContents;
	private String category;
	private String shopImage;
	
	
	public OnlineShop(int shopNo, String shopName, String shopContents, String category, String shopImage) {
		super();
		this.shopNo = shopNo;
		this.shopName = shopName;
		this.shopContents = shopContents;
		this.category = category;
		this.shopImage = shopImage;
	}


	public int getShopNo() {
		return shopNo;
	}


	public void setShopNo(int shopNo) {
		this.shopNo = shopNo;
	}


	public String getShopName() {
		return shopName;
	}


	public void setShopName(String shopName) {
		this.shopName = shopName;
	}


	public String getShopContents() {
		return shopContents;
	}


	public void setShopContents(String shopContents) {
		this.shopContents = shopContents;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public String getShopImage() {
		return shopImage;
	}


	public void setShopImage(String shopImage) {
		this.shopImage = shopImage;
	}


	@Override
	public String toString() {
		return "OnlineShop [shopNo=" + shopNo + ", shopName=" + shopName + ", shopContents=" + shopContents
				+ ", category=" + category + ", shopImage=" + shopImage + "]";
	}

}
