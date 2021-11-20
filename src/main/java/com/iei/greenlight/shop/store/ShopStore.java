package com.iei.greenlight.shop.store;

import java.util.HashMap;
import java.util.List;

import com.iei.greenlight.shop.domain.OfflinePageInfo;
import com.iei.greenlight.shop.domain.OfflineShop;
import com.iei.greenlight.shop.domain.OnlinePageInfo;
import com.iei.greenlight.shop.domain.OnlineShop;

public interface ShopStore {
	
	// 오프라인
	public List<OfflineShop> selectOfflineShopList(OfflinePageInfo pi);
	public List<OfflineShop> selectOfflineSearchList(HashMap<String, Object> hashmap);
	public OfflineShop selectOfflineOneByNo(int shopNo);
	public int selectOfflineListCount();
	public int selectSearchOfflineListCount(String searchKeyWord);
	public int insertOfflineShop(OfflineShop offlineShop);
	public OfflineShop printOfflineShopOneByNo(int shopNo);
	public int updateOfflineShop(OfflineShop offlineShop);
	public int deleteOfflineShop(int[] shopNo);
	
	// 온라인
	public List<OnlineShop> selectZeroWasteList(OnlinePageInfo pi);
	public int selectZeroWasteListCount();
	public List<OnlineShop> selectUpCyclingList(OnlinePageInfo pi);
	public int selectUpCyclingListCount();
	public List<OnlineShop> selectOnlineShopList(OfflinePageInfo pi);
	public int selectOnlineListCount();
	public List<OnlineShop> selectOnlineListOneByNo(HashMap<String, int[]> hashmap);
	public List<OnlineShop> selectOnlineSearchList(HashMap<String, Object> hashmap);
	public int selectOnlineSearchListCount(String searchKeyWord);
	public int insertOnlineShop(OnlineShop onlineShop);
	public int deleteOnlineShop(int[] shopNo);

}
