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
		return sqlSession.selectList("shopMapper.selectOfflineShopList", pi, rowBounds);
	}

	@Override
	public List<OfflineShop> selectOfflineSearchList(HashMap<String, Object> hashmap) {
		OfflinePageInfo pi = (OfflinePageInfo)hashmap.get("pi");
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		return sqlSession.selectList("shopMapper.selectOfflineSearchList", hashmap.get("searchKeyWord"), rowBounds);
	}
	
	@Override
	public OfflineShop selectOfflineOneByNo(int shopNo) {
		return sqlSession.selectOne("shopMapper.selectOfflineOneByNo", shopNo);
	}

	@Override
	public int selectOfflineListCount() {
		return sqlSession.selectOne("shopMapper.selectOfflineListCount");
	}
	
	@Override
	public int selectSearchOfflineListCount(String searchKeyWord) {
		return sqlSession.selectOne("shopMapper.selectSearchOfflineListCount", searchKeyWord);
	}
	
	@Override
	public int insertOfflineShop(OfflineShop offlineShop) {
		return sqlSession.insert("shopMapper.insertOfflineShop", offlineShop);
	}
	
	@Override
	public OfflineShop printOfflineShopOneByNo(int shopNo) {
		return sqlSession.selectOne("shopMapper.selectOfflineShopOneByNo", shopNo);
	}
	
	@Override
	public int updateOfflineShop(OfflineShop offlineShop) {
		return sqlSession.update("shopMapper.updateOfflineShop", offlineShop);
	}

	@Override
	public int deleteOfflineShop(int[] shopNo) {
		return sqlSession.delete("shopMapper.deleteOfflineShop", shopNo);
	}

	@Override
	public List<OnlineShop> selectOnlineShopList(OfflinePageInfo pi) {
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		return sqlSession.selectList("shopMapper.selectOnlineList", pi, rowBounds);
	}

	
	@Override
	public int selectOnlineListCount() {
		return sqlSession.selectOne("shopMapper.selectOnlineListCount");
	}
	
	@Override
	public List<OnlineShop> selectZeroWasteList(OnlinePageInfo pi) {
		int offset = (pi.getCurrentPage() - 1) * pi.getOnlineShopLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getOnlineShopLimit());
		return sqlSession.selectList("shopMapper.selectZeroWateList", pi, rowBounds);
	}

	@Override
	public int selectZeroWasteListCount() {
		return sqlSession.selectOne("shopMapper.selectZeroWasteListCount");
	}

	@Override
	public List<OnlineShop> selectUpCyclingList(OnlinePageInfo pi) {
		int offset = (pi.getCurrentPage() - 1) * pi.getOnlineShopLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getOnlineShopLimit());
		return sqlSession.selectList("shopMapper.selectUpCyclingList", pi, rowBounds);
	}
	
	@Override
	public int selectUpCyclingListCount() {
		return sqlSession.selectOne("shopMapper.selectUpCyclingListCount");
	}

	@Override
	public List<OnlineShop> selectOnlineListOneByNo(HashMap<String, int[]> hashmap) {
		return sqlSession.selectList("shopMapper.selectOnlineListOneByNo", hashmap);
	}
	
	@Override
	public List<OnlineShop> selectOnlineSearchList(HashMap<String, Object> hashmap) {
		OfflinePageInfo pi = (OfflinePageInfo) hashmap.get("pi");
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		return sqlSession.selectList("shopMapper.selectOnlineSearchList", hashmap.get("searchKeyWord"), rowBounds);
	}
	
	@Override
	public int selectOnlineSearchListCount(String searchKeyWord) {
		return sqlSession.selectOne("shopMapper.selectOnlineSearchCount", searchKeyWord);
	}
	
	@Override
	public OnlineShop selectOnlineShopOneByNo(int shopNo) {
		return sqlSession.selectOne("shopMapper.selectOnlineShopOneByNo", shopNo);
	}
	
	@Override
	public int deleteOnlineShop(int[] shopNo) {
		return sqlSession.delete("shopMapper.deleteOnlineShop", shopNo);
	}
	
	@Override
	public int updateOnlineShop(OnlineShop onlineShop) {
		return sqlSession.update("shopMapper.updateOnlineShop", onlineShop);
	}
	
	@Override
	public int insertOnlineShop(OnlineShop onlineShop) {
		return sqlSession.insert("shopMapper.insertOnlineShop", onlineShop);
	}



}
