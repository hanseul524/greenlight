package com.iei.greenlight.chargePoint.controller;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iei.greenlight.chargePoint.common.Pagination;
import com.iei.greenlight.chargePoint.domain.ChargePoint;
import com.iei.greenlight.chargePoint.domain.PageInfo;
import com.iei.greenlight.chargePoint.service.ChargePointService;
import com.iei.greenlight.mypage.domain.PointHistory;
import com.iei.greenlight.user.domain.User;
import com.iei.greenlight.user.service.UserService;

@Controller
public class ChargePointController {

	@Autowired
	private ChargePointService service;
	@Autowired
	private UserService uService;
	
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
	
	// 충전 웹 이동
	@RequestMapping(value="cpPopView.do", method=RequestMethod.GET)
	public String cpPopView(HttpServletRequest request,Model model) {
		String userId = (String)request.getSession().getAttribute("userId");
		User userOne = uService.printUser(userId);
		model.addAttribute("userOne", userOne);
		return "chargePoint/cpPopup";
	}
	
	// 포인트 충전
	@ResponseBody
	@RequestMapping(value="chargePoint.do", method=RequestMethod.POST)
	public String chargePoint(HttpServletRequest request, @RequestParam("chargeMoney") int chargeMoney, @RequestParam("imp_uid") String impUid) {
		String userId = (String)request.getSession().getAttribute("userId");
		int chargePoint = chargeMoney;
		ChargePoint cp = new ChargePoint();
		cp.setUserId(userId);
		cp.setChargeMoney(chargeMoney);
		cp.setChargePoint(chargePoint);
		cp.setImpUid(impUid);
		int result = service.registerChargePoint(cp);
		int uResult = 0;
		int phResult = 0;
		int sum = 0;
		if(result > 0) {
			User userOne = new User();
			userOne.setUserId(userId);
			userOne.setChargePoint(chargePoint);
			uResult = uService.modifyChargePoint(userOne);
			PointHistory pHistory = new PointHistory();
			pHistory.setUserId(userId);
			pHistory.setPointContents("포인트 충전");
			pHistory.setPointPayment(chargePoint);
			phResult = service.registerChargePoint(pHistory);
			sum = result + uResult + phResult;
			return String.valueOf(sum);
		}else {
			return String.valueOf(sum);
		}
	}
	
	// 취소요청
	@RequestMapping(value="chargeCancel.do", method=RequestMethod.POST)
	public String chargeCancel(@RequestParam("impUid") String impUid, @RequestParam("chargeMoney") int chargeMoney) {
		
		return "";
	}
	
}
