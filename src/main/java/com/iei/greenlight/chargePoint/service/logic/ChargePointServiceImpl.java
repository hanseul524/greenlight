package com.iei.greenlight.chargePoint.service.logic;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iei.greenlight.chargePoint.domain.ChargePoint;
import com.iei.greenlight.chargePoint.service.ChargePointService;
import com.iei.greenlight.chargePoint.store.ChargePointStore;

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
}
