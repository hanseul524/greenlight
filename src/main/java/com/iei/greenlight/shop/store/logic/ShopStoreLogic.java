package com.iei.greenlight.shop.store.logic;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iei.greenlight.shop.domain.OfflinePageInfo;
import com.iei.greenlight.shop.domain.OfflineShop;
import com.iei.greenlight.shop.store.ShopStore;

@Repository
public class ShopStoreLogic implements ShopStore{
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<OfflineShop> selectOfflineShopList(OfflinePageInfo pi) {
		
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		List<OfflineShop> sList = sqlSession.selectList("offlineShopMapper.selectOfflineShopList", pi, rowBounds);
		
		return sList;
	}

	@Override
	public List<OfflineShop> selectOfflineSearchList(String searchKeyWord) {
		
		List<OfflineShop> sList = sqlSession.selectList("offlineShopMapper.selectOfflineSearchList", searchKeyWord);
		
		return sList;
	}
	
	@Override
	public OfflineShop selectOfflineOneByNo(int shopNo) {
		
		OfflineShop offlineShop = sqlSession.selectOne("offlineShopMapper.selectOfflineOneByNo", shopNo);
		
		return offlineShop;
	}

	@Override
	public int selectOfflineListCount() {
		
		int count = sqlSession.selectOne("offlineShopMapper.selectOfflineListCount");
		
		return count;
	}

	@Override
	public int deleteOfflineShop(int[] shopNo) {
		
		int result = sqlSession.delete("offlineShopMapper.deleteOfflineShop", shopNo);
		
		return result;
	}


}
