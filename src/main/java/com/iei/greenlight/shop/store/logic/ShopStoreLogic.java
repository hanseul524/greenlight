package com.iei.greenlight.shop.store.logic;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iei.greenlight.shop.domain.OfflineShop;
import com.iei.greenlight.shop.store.ShopStore;

@Repository
public class ShopStoreLogic implements ShopStore{
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<OfflineShop> selectOfflineShopList() {
		
		List<OfflineShop> sList = sqlSession.selectList("offlineShopMapper.selectOfflineShopList");
		
		return sList;
	}

}
