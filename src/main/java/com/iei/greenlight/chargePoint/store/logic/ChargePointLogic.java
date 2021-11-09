package com.iei.greenlight.chargePoint.store.logic;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iei.greenlight.chargePoint.domain.ChargePoint;
import com.iei.greenlight.chargePoint.store.ChargePointStore;

@Repository
public class ChargePointLogic implements ChargePointStore{
	
	@Autowired
	private SqlSessionTemplate sqlsession;

	@Override
	public List<ChargePoint> selectUserIdList(String userId) {
		List<ChargePoint> cpList = sqlsession.selectList("chargePointMapper.selectUserIdList", userId);
		return cpList;
	}
}
