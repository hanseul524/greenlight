package com.iei.greenlight.shop.service.logic;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iei.greenlight.shop.domain.OfflinePageInfo;
import com.iei.greenlight.shop.domain.OfflineShop;
import com.iei.greenlight.shop.domain.OnlinePageInfo;
import com.iei.greenlight.shop.domain.OnlineShop;
import com.iei.greenlight.shop.service.ShopService;
import com.iei.greenlight.shop.store.ShopStore;

@Service
public class ShopServiceImpl implements ShopService{
	
	@Autowired
	private ShopStore store;

	@Override
	public List<OfflineShop> printOfflineShopList(OfflinePageInfo pi) {

		List<OfflineShop> sList = store.selectOfflineShopList(pi);
		
		return sList;
	}

	@Override
	public List<OfflineShop> printOfflineSearchList(HashMap<String, Object> hashmap) {
		
		List<OfflineShop> sList = store.selectOfflineSearchList(hashmap);
		
		return sList;
	}
	
	@Override
	public OfflineShop printOfflineOneByNo(int shopNo) {
		
		OfflineShop offlineShop = store.selectOfflineOneByNo(shopNo);
		
		return offlineShop;
	}

	@Override
	public int getOfflineListCount() {
		
		int count = store.selectOfflineListCount();
		
		return count;
	}
	
	@Override
	public int getSearchOfflineListCount(String searchKeyWord) {
		
		int count = store.selectSearchOfflineListCount(searchKeyWord);
		
		return count;
	}
	
	@Override
	public int registerOfflineShop(OfflineShop offlineShop) {
		
		int result = store.insertOfflineShop(offlineShop);
		
		return result;
	}
	


	@Override
	public int removeOfflineShop(int[] shopNo) {
		
		int result = store.deleteOfflineShop(shopNo);
		
		return result;
	}

	@Override
	public List<OnlineShop> printOnlineShopList(OfflinePageInfo pi) {
		
		List<OnlineShop> sList = store.selectOnlineShopList(pi);
		
		return sList;
	}

	@Override
	public int getOnlineListCount() {
		
		int count = store.selectOnlineListCount();
		
		return count;
	}

	@Override
	public int registerOnlineShop(OnlineShop onlineShop) {
		
		int result = store.insertOnlineShop(onlineShop);
		
		return result;
	}

	@Override
	public List<OnlineShop> printZeroWasteShopList(OnlinePageInfo pi) {

		List<OnlineShop> sList = store.selectZeroWasteList(pi);
		
		return sList;
	}

	@Override
	public int getZeroWasteListCount() {
		
		int count = store.selectZeroWasteListCount();
				
		return count;
	}






}
