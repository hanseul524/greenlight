package com.iei.greenlight.shop.service;

import java.util.HashMap;
import java.util.List;

import com.iei.greenlight.shop.domain.OfflinePageInfo;
import com.iei.greenlight.shop.domain.OfflineShop;
import com.iei.greenlight.shop.domain.OnlinePageInfo;
import com.iei.greenlight.shop.domain.OnlineShop;

public interface ShopService {
	
	// 오프라인
	public List<OfflineShop> printOfflineShopList(OfflinePageInfo pi);
	public List<OfflineShop> printOfflineSearchList(HashMap<String, Object> hashmap);
	public OfflineShop printOfflineOneByNo(int shopNo);
	public int getOfflineListCount();
	public int getSearchOfflineListCount(String searchKeyWordHashMap);
	public int registerOfflineShop(OfflineShop offlineShop);
	public int removeOfflineShop(int[] shopNo);
	
	//온라인
	public List<OnlineShop> printZeroWasteShopList(OnlinePageInfo pi);
	public int getZeroWasteListCount();
	public List<OnlineShop> printOnlineShopList(OfflinePageInfo pi);
	public int getOnlineListCount();
	public int registerOnlineShop(OnlineShop onlineShop);

}
