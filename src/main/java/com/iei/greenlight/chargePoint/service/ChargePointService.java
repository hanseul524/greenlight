package com.iei.greenlight.chargePoint.service;

import java.util.HashMap;
import java.util.List;

import com.iei.greenlight.chargePoint.domain.ChargePoint;
import com.iei.greenlight.chargePoint.domain.PageInfo;

public interface ChargePointService {


	int getListCount(String userId);

	List<ChargePoint> showList(HashMap<String, Object> hashMap);

}
