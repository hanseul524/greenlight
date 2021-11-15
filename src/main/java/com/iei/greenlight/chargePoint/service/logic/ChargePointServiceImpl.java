package com.iei.greenlight.chargePoint.service.logic;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iei.greenlight.chargePoint.domain.ChargePoint;
import com.iei.greenlight.chargePoint.service.ChargePointService;
import com.iei.greenlight.chargePoint.store.ChargePointStore;
import com.iei.greenlight.mypage.domain.PointHistory;

@Service
public class ChargePointServiceImpl implements ChargePointService {

	@Autowired
	private ChargePointStore store;


	@Override
	public int getListCount(String userId) {
		return store.selectListCount(userId);
	}


	@Override
	public List<ChargePoint> showList(HashMap<String, Object> hashMap) {
		
		return store.selectList(hashMap);
	}


	// chargePoint 테이블 등록
	@Override
	public int registerChargePoint(ChargePoint cp) {
		return store.insertChargePoint(cp);
	}

	// pointHistory 테이블 등록
	@Override
	public int registerChargePoint(PointHistory pHistory) {
		return store.insertPHChargePoint(pHistory);
	}


	@Override
	public int getChargePoint(String userId) {
		return store.selectUserChargePoint(userId);
	}


	@Override
	public int cancelPoint(ChargePoint cp) {
		return store.cancelPoint(cp);
	}


	@Override
	public int registerCancelChargePoint(PointHistory ph) {
		return store.insertPHCancelChargePoint(ph);
	}
}
