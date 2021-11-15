package com.iei.greenlight.chargePoint.store;

import java.util.HashMap;
import java.util.List;

import com.iei.greenlight.chargePoint.domain.ChargePoint;
import com.iei.greenlight.chargePoint.domain.PageInfo;
import com.iei.greenlight.mypage.domain.PointHistory;

public interface ChargePointStore {


	int selectListCount(String userId);

	List<ChargePoint> selectList(HashMap<String, Object> hashMap);

	int insertChargePoint(ChargePoint cp);

	int insertPHChargePoint(PointHistory pHistory);

	int selectUserChargePoint(String userId);

	int cancelPoint(ChargePoint cp);

	int insertPHCancelChargePoint(PointHistory ph);

}
