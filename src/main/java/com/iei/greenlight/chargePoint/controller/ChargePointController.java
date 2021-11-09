package com.iei.greenlight.chargePoint.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.iei.greenlight.chargePoint.domain.ChargePoint;
import com.iei.greenlight.chargePoint.service.ChargePointService;

@Controller
public class ChargePointController {

	@Autowired
	private ChargePointService service;
	
	// 충전포인트 리스트
	@RequestMapping(value="chargeList.do", method=RequestMethod.GET)
	public String chargePointListView(HttpServletRequest request, Model model) {
		String userId = (String)request.getSession().getAttribute("userId");
		List<ChargePoint> cpList = service.showList(userId);
		model.addAttribute("cpList", cpList);
		return "chargePoint/pointList";
	}
}
