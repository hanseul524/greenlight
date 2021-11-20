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
		return sqlSession.selectList("ShopMapper.selectOfflineShopList", pi, rowBounds);
	}

	@Override
	public List<OfflineShop> selectOfflineSearchList(HashMap<String, Object> hashmap) {
		OfflinePageInfo pi = (OfflinePageInfo)hashmap.get("pi");
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		return sqlSession.selectList("ShopMapper.selectOfflineSearchList", hashmap.get("searchKeyWord"), rowBounds);
	}
	
	@Override
	public OfflineShop selectOfflineOneByNo(int shopNo) {
		return sqlSession.selectOne("ShopMapper.selectOfflineOneByNo", shopNo);
	}

	@Override
	public int selectOfflineListCount() {
		return sqlSession.selectOne("ShopMapper.selectOfflineListCount");
	}
	
	@Override
	public int selectSearchOfflineListCount(String searchKeyWord) {
		return sqlSession.selectOne("ShopMapper.selectSearchOfflineListCount", searchKeyWord);
	}
	
	@Override
	public int insertOfflineShop(OfflineShop offlineShop) {
		return sqlSession.insert("ShopMapper.insertOfflineShop", offlineShop);
	}
	
	@Override
	public OfflineShop printOfflineShopOneByNo(int shopNo) {
		return sqlSession.selectOne("ShopMapper.selectOfflineShopOneByNo", shopNo);
	}
	
	@Override
	public int updateOfflineShop(OfflineShop offlineShop) {
		return sqlSession.update("ShopMapper.updateOfflineShop", offlineShop);
	}

	@Override
	public int deleteOfflineShop(int[] shopNo) {
		return sqlSession.delete("ShopMapper.deleteOfflineShop", shopNo);
	}

	@Override
	public List<OnlineShop> selectOnlineShopList(OfflinePageInfo pi) {
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		return sqlSession.selectList("ShopMapper.selectOnlineList", pi, rowBounds);
	}

	
	@Override
	public int selectOnlineListCount() {
		return sqlSession.selectOne("ShopMapper.selectOnlineListCount");
	}
	
	@Override
	public List<OnlineShop> selectZeroWasteList(OnlinePageInfo pi) {
		int offset = (pi.getCurrentPage() - 1) * pi.getOnlineShopLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getOnlineShopLimit());
		return sqlSession.selectList("ShopMapper.selectZeroWateList", pi, rowBounds);
	}

	@Override
	public int selectZeroWasteListCount() {
		return sqlSession.selectOne("ShopMapper.selectZeroWasteListCount");
	}

	@Override
	public List<OnlineShop> selectUpCyclingList(OnlinePageInfo pi) {
		int offset = (pi.getCurrentPage() - 1) * pi.getOnlineShopLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getOnlineShopLimit());
		return sqlSession.selectList("ShopMapper.selectUpCyclingList", pi, rowBounds);
	}
	
	@Override
	public int selectUpCyclingListCount() {
		return sqlSession.selectOne("ShopMapper.selectUpCyclingListCount");
	}

	@Override
	public List<OnlineShop> selectOnlineListOneByNo(HashMap<String, int[]> hashmap) {
		return sqlSession.selectList("ShopMapper.selectOnlineListOneByNo", hashmap);
	}
	
	@Override
	public List<OnlineShop> selectOnlineSearchList(HashMap<String, Object> hashmap) {
		OfflinePageInfo pi = (OfflinePageInfo) hashmap.get("pi");
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		return sqlSession.selectList("ShopMapper.selectOnlineSearchList", hashmap.get("searchKeyWord"), rowBounds);
	}
	
	@Override
	public int selectOnlineSearchListCount(String searchKeyWord) {
		return sqlSession.selectOne("ShopMapper.selectOnlineSearchCount", searchKeyWord);
	}
	
	@Override
	public int deleteOnlineShop(int[] shopNo) {
		return sqlSession.delete("ShopMapper.deleteOnlineShop", shopNo);
	}
	
	@Override
	public int insertOnlineShop(OnlineShop onlineShop) {
		return sqlSession.insert("ShopMapper.insertOnlineShop", onlineShop);
	}

}
