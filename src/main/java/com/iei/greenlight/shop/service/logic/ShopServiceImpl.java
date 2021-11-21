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
		return store.selectOfflineShopList(pi);
	}

	@Override
	public List<OfflineShop> printOfflineSearchList(HashMap<String, Object> hashmap) {
		return store.selectOfflineSearchList(hashmap);
	}
	
	@Override
	public OfflineShop printOfflineOneByNo(int shopNo) {
		return store.selectOfflineOneByNo(shopNo);
	}

	@Override
	public int getOfflineListCount() {
		return store.selectOfflineListCount();
	}
	
	@Override
	public int getSearchOfflineListCount(String searchKeyWord) {
		return store.selectSearchOfflineListCount(searchKeyWord);
	}
	
	@Override
	public int registerOfflineShop(OfflineShop offlineShop) {
		return store.insertOfflineShop(offlineShop);
	}
	
	@Override
	public OfflineShop printOfflineShopOneByNo(int shopNo) {
		return store.printOfflineShopOneByNo(shopNo);
	}
	
	@Override
	public int modifyOfflineShop(OfflineShop offlineShop) {
		return store.updateOfflineShop(offlineShop);
	}
	
	@Override
	public int removeOfflineShop(int[] shopNo) {
		return store.deleteOfflineShop(shopNo);
	}

	@Override
	public List<OnlineShop> printOnlineShopList(OfflinePageInfo pi) {
		return store.selectOnlineShopList(pi);
	}

	@Override
	public int getOnlineListCount() {
		return store.selectOnlineListCount();
	}

	@Override
	public List<OnlineShop> printZeroWasteShopList(OnlinePageInfo pi) {
		return store.selectZeroWasteList(pi);
	}

	@Override
	public int getZeroWasteListCount() {
		return store.selectZeroWasteListCount();
	}
	
	@Override
	public List<OnlineShop> printUpCyclingShopList(OnlinePageInfo pi) {
		return store.selectUpCyclingList(pi);
	}
	
	@Override
	public int getUpCyclingListCount() {
		return store.selectUpCyclingListCount();
	}

	@Override
	public List<OnlineShop> printOnlineShopOneByNo(HashMap<String, int[]> hashmap) {
		return store.selectOnlineListOneByNo(hashmap);
	}
	
	@Override
	public List<OnlineShop> printOnlineShopSearchList(HashMap<String, Object> hashmap) {
		return store.selectOnlineSearchList(hashmap);
	}
	
	@Override
	public int getOnlineSearchListCount(String searchKeyWord) {
		return store.selectOnlineSearchListCount(searchKeyWord);
	}
	
	@Override
	public OnlineShop printOnlineShopOneByNo(int shopNo) {
		return store.selectOnlineShopOneByNo(shopNo);
	}
	
	@Override
	public int registerOnlineShop(OnlineShop onlineShop) {
		return store.insertOnlineShop(onlineShop);
	}
	
	@Override
	public int modifyOnlineShop(OnlineShop onlineShop) {
		return store.updateOnlineShop(onlineShop);
	}
	
	@Override
	public int removeOnlineShop(int[] shopNo) {
		return store.deleteOnlineShop(shopNo);
	}






}
