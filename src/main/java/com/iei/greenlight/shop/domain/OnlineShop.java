package com.iei.greenlight.shop.domain;

public class OnlineShop {
	
	private int shopNo;
	private String shopName;
	private String shopContents;
	private String shopAddress;
	private String shopImage;
	private String category;
	
	public OnlineShop() {}

	public OnlineShop(int shopNo, String shopName, String shopContents, String shopAddress, String shopImage,
			String category) {
		super();
		this.shopNo = shopNo;
		this.shopName = shopName;
		this.shopContents = shopContents;
		this.shopAddress = shopAddress;
		this.shopImage = shopImage;
		this.category = category;
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

	public String getShopAddress() {
		return shopAddress;
	}

	public void setShopAddress(String shopAddress) {
		this.shopAddress = shopAddress;
	}

	public String getShopImage() {
		return shopImage;
	}

	public void setShopImage(String shopImage) {
		this.shopImage = shopImage;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "OnlineShop [shopNo=" + shopNo + ", shopName=" + shopName + ", shopContents=" + shopContents
				+ ", shopAddress=" + shopAddress + ", shopImage=" + shopImage + ", category=" + category + "]";
	}
	
}
