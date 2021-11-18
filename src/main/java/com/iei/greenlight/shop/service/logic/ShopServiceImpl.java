package com.iei.greenlight.shop.service.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iei.greenlight.shop.domain.OfflinePageInfo;
import com.iei.greenlight.shop.domain.OfflineShop;
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
	public List<OfflineShop> printOfflineSearchList(String searchKeyWord) {
		
		List<OfflineShop> sList = store.selectOfflineSearchList(searchKeyWord);
		
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
	public int removeOfflineShop(int[] shopNo) {
		
		int result = store.deleteOfflineShop(shopNo);
		
		return result;
	}


}
