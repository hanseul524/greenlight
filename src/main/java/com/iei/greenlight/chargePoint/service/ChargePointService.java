package com.iei.greenlight.chargePoint.service;

import java.util.HashMap;
import java.util.List;

import com.iei.greenlight.chargePoint.domain.ChargePoint;
import com.iei.greenlight.chargePoint.domain.PageInfo;
import com.iei.greenlight.mypage.domain.PointHistory;

public interface ChargePointService {


	int getListCount(String userId);

	List<ChargePoint> showList(HashMap<String, Object> hashMap);

	int registerChargePoint(ChargePoint cp);

	int registerChargePoint(PointHistory pHistory);

	int getChargePoint(String userId);

	int cancelPoint(ChargePoint cp);

	int registerCancelChargePoint(PointHistory ph);

}
