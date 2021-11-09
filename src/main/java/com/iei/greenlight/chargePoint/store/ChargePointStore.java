package com.iei.greenlight.chargePoint.store;

import java.util.List;

import com.iei.greenlight.chargePoint.domain.ChargePoint;

public interface ChargePointStore {

	List<ChargePoint> selectUserIdList(String userId);

}
