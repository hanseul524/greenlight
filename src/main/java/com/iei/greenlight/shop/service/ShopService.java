package com.iei.greenlight.shop.service;

import java.util.List;

import com.iei.greenlight.shop.domain.OfflineShop;

public interface ShopService {
	
	public List<OfflineShop> printOfflineShopList();
	public List<OfflineShop> printOfflineSearchList(String searchKeyWord);
	public OfflineShop printOfflineOneByNo(int shopNo);

}
