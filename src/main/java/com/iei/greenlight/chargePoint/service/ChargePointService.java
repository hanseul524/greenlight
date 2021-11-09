package com.iei.greenlight.chargePoint.service;

import java.util.List;

import com.iei.greenlight.chargePoint.domain.ChargePoint;

public interface ChargePointService {

	List<ChargePoint> showList(String userId);

}
