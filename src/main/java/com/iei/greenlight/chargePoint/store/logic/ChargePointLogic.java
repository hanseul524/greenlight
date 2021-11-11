package com.iei.greenlight.chargePoint.store.logic;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iei.greenlight.chargePoint.domain.ChargePoint;
import com.iei.greenlight.chargePoint.domain.PageInfo;
import com.iei.greenlight.chargePoint.store.ChargePointStore;

@Repository
public class ChargePointLogic implements ChargePointStore{
	
	@Autowired
	private SqlSessionTemplate sqlSession;


	@Override
	public int selectListCount(String userId) {
		return sqlSession.selectOne("chargePointMapper.selectListCount", userId);
	}


	@Override
	public List<ChargePoint> selectList(HashMap<String, Object> hashMap) {
		PageInfo pi = (PageInfo)(hashMap.get("pi"));
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		return sqlSession.selectList("chargePointMapper.selectUserIdList", hashMap, rowBounds);
	}
}
