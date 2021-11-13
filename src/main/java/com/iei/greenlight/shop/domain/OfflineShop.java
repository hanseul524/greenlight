package com.iei.greenlight.shop.domain;

public class OfflineShop {
	
	private int shopNo;
	private String shopName;
	private String shopAddress;
	private String shopInstagram;
	private String category;
	private String shopPhone;
	
	public OfflineShop() {}
	
	public OfflineShop(int shopNo, String shopName, String shopAddress, String shopInstagram, String category,
			String shopPhone) {
		super();
		this.shopNo = shopNo;
		this.shopName = shopName;
		this.shopAddress = shopAddress;
		this.shopInstagram = shopInstagram;
		this.category = category;
		this.shopPhone = shopPhone;
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

	public String getShopAddress() {
		return shopAddress;
	}

	public void setShopAddress(String shopAddress) {
		this.shopAddress = shopAddress;
	}

	public String getShopInstagram() {
		return shopInstagram;
	}

	public void setShopInstagram(String shopInstagram) {
		this.shopInstagram = shopInstagram;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getShopPhone() {
		return shopPhone;
	}

	public void setShopPhone(String shopPhone) {
		this.shopPhone = shopPhone;
	}

	@Override
	public String toString() {
		return "OfflineShop [shopNo=" + shopNo + ", shopName=" + shopName + ", shopAddress=" + shopAddress
				+ ", shopInstagram=" + shopInstagram + ", category=" + category + ", shopPhone=" + shopPhone + "]";
	}

}
