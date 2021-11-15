package com.iei.greenlight.shop.service.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iei.greenlight.shop.domain.OfflineShop;
import com.iei.greenlight.shop.service.ShopService;
import com.iei.greenlight.shop.store.ShopStore;

@Service
public class ShopServiceImpl implements ShopService{
	
	@Autowired
	private ShopStore store;

	@Override
	public List<OfflineShop> printOfflineShopList() {

		List<OfflineShop> sList = store.selectOfflineShopList();
		
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


}
