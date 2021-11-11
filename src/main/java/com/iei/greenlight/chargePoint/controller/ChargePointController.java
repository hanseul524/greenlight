package com.iei.greenlight.chargePoint.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.iei.greenlight.chargePoint.common.Pagination;
import com.iei.greenlight.chargePoint.domain.ChargePoint;
import com.iei.greenlight.chargePoint.domain.PageInfo;
import com.iei.greenlight.chargePoint.service.ChargePointService;

@Controller
public class ChargePointController {

	@Autowired
	private ChargePointService service;
	
	// 충전포인트 리스트
	@RequestMapping(value="chargeList.do", method=RequestMethod.GET)
	public String chargePointListView(HttpServletRequest request, Model model, @RequestParam(value="page", required=false) Integer page) {
		String userId = (String)request.getSession().getAttribute("userId");
		int currentPage = (page != null) ? page : 1;
		int totalCount = service.getListCount(userId);
		PageInfo pi = Pagination.getPageInfo(currentPage, totalCount);
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("pi", pi);
		hashMap.put("userId", userId);
		List<ChargePoint> cpList = service.showList(hashMap);
		model.addAttribute("cpList", cpList);
		model.addAttribute("pi", pi);
		return "chargePoint/pointList";
	}
	
	@RequestMapping(value="cpPopView.do", method=RequestMethod.GET)
	public String cpPopView() {
		
		return "chargePoint/cpPopup";
	}
}
