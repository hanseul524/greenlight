package com.iei.greenlight.shop.service;

import java.util.List;

import com.iei.greenlight.shop.domain.OfflinePageInfo;
import com.iei.greenlight.shop.domain.OfflineShop;

public interface ShopService {
	
	public List<OfflineShop> printOfflineShopList(OfflinePageInfo pi);
	public List<OfflineShop> printOfflineSearchList(String searchKeyWord);
	public OfflineShop printOfflineOneByNo(int shopNo);
	public int getOfflineListCount();
	public int removeOfflineShop(int[] shopNo);

}
