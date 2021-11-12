package com.iei.greenlight.chargePoint.store;

import java.util.HashMap;
import java.util.List;

import com.iei.greenlight.chargePoint.domain.ChargePoint;
import com.iei.greenlight.chargePoint.domain.PageInfo;

public interface ChargePointStore {


	int selectListCount(String userId);

	List<ChargePoint> selectList(HashMap<String, Object> hashMap);

}
