package com.iei.greenlight.shop.store.logic;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iei.greenlight.shop.domain.OfflinePageInfo;
import com.iei.greenlight.shop.domain.OfflineShop;
import com.iei.greenlight.shop.domain.OnlinePageInfo;
import com.iei.greenlight.shop.domain.OnlineShop;
import com.iei.greenlight.shop.store.ShopStore;

@Repository
public class ShopStoreLogic implements ShopStore{
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<OfflineShop> selectOfflineShopList(OfflinePageInfo pi) {
		
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		List<OfflineShop> sList = sqlSession.selectList("ShopMapper.selectOfflineShopList", pi, rowBounds);
		
		return sList;
	}

	@Override
	public List<OfflineShop> selectOfflineSearchList(HashMap<String, Object> hashmap) {
		
		OfflinePageInfo pi = (OfflinePageInfo)hashmap.get("pi");
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		List<OfflineShop> sList = sqlSession.selectList("ShopMapper.selectOfflineSearchList", hashmap.get("searchKeyWord"), rowBounds);
		
		return sList;
	}
	
	@Override
	public OfflineShop selectOfflineOneByNo(int shopNo) {
		
		OfflineShop offlineShop = sqlSession.selectOne("ShopMapper.selectOfflineOneByNo", shopNo);
		
		return offlineShop;
	}

	@Override
	public int selectOfflineListCount() {
		
		int count = sqlSession.selectOne("ShopMapper.selectOfflineListCount");
		
		return count;
	}
	
	@Override
	public int selectSearchOfflineListCount(String searchKeyWord) {
		
		int count = sqlSession.selectOne("ShopMapper.selectSearchOfflineListCount", searchKeyWord);
		
		return count;
	}
	
	@Override
	public int insertOfflineShop(OfflineShop offlineShop) {
		
		int result = sqlSession.insert("ShopMapper.insertOfflineShop", offlineShop);
		
		return result;
	}


	@Override
	public int deleteOfflineShop(int[] shopNo) {
		
		int result = sqlSession.delete("ShopMapper.deleteOfflineShop", shopNo);
		
		return result;
	}
	

	@Override
	public List<OnlineShop> selectOnlineShopList(OfflinePageInfo pi) {
		
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		List<OnlineShop> sList = sqlSession.selectList("ShopMapper.selectOnlineList", pi, rowBounds);
		
		return sList;
	}

	
	@Override
	public int selectOnlineListCount() {

		int count = sqlSession.selectOne("ShopMapper.selectOnlineListCount");
		
		return count;
	}
	
	
	@Override
	public int insertOnlineShop(OnlineShop onlineShop) {
		
		int result = sqlSession.insert("ShopMapper.insertOnlineShop", onlineShop);
		
		return result;
	}

	@Override
	public List<OnlineShop> selectZeroWasteList(OnlinePageInfo pi) {
		
		int offset = (pi.getCurrentPage() - 1) * pi.getOnlineShopLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getOnlineShopLimit());
		List<OnlineShop> sList = sqlSession.selectList("ShopMapper.selectZeroWateList", pi, rowBounds);
		
		return sList;
	}

	@Override
	public int selectZeroWasteListCount() {
		int count = sqlSession.selectOne("ShopMapper.selectZeroWasteListCount");
		return count;
	}



}
