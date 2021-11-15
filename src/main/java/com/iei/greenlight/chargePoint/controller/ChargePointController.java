package com.iei.greenlight.chargePoint.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.client.HttpClient;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
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
	@RequestMapping(value = "chargeList.do", method = RequestMethod.GET)
	public String chargePointListView(HttpServletRequest request, Model model,
			@RequestParam(value = "page", required = false) Integer page) {
		String userId = (String) request.getSession().getAttribute("userId");
		int currentPage = (page != null) ? page : 1;
		int totalCount = service.getListCount(userId);
		PageInfo pi = Pagination.getPageInfo(currentPage, totalCount);
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		int chargePoint = service.getChargePoint(userId);
		hashMap.put("pi", pi);
		hashMap.put("userId", userId);
		List<ChargePoint> cpList = service.showList(hashMap);
		model.addAttribute("cpList", cpList);
		model.addAttribute("pi", pi);
		model.addAttribute("chargePoint", chargePoint);
		return "chargePoint/pointList";
	}

	// 충전 웹 이동
	@RequestMapping(value = "cpPopView.do", method = RequestMethod.GET)
	public String cpPopView(HttpServletRequest request, Model model) {
		String userId = (String) request.getSession().getAttribute("userId");
		User userOne = uService.printUser(userId);
		model.addAttribute("userOne", userOne);
		return "chargePoint/cpPopup";
	}

	// 포인트 충전
	@ResponseBody
	@RequestMapping(value = "chargePoint.do", method = RequestMethod.POST)
	public String chargePoint(HttpServletRequest request, @RequestParam("chargeMoney") int chargeMoney,
			@RequestParam("imp_uid") String impUid) {
		String userId = (String) request.getSession().getAttribute("userId");
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
		if (result > 0) {
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
		} else {
			return String.valueOf(sum);
		}
	}

	// 취소요청
	@ResponseBody
	@RequestMapping(value = "chargeCancel.do", method = RequestMethod.GET)
	public void chargeCancel(@RequestParam("impUid") String impUid, @RequestParam("chargeMoney") int chargeMoney,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		ChargePoint cp = new ChargePoint();
		User user = new User();
		PointHistory ph = new PointHistory();
		String userId = (String) request.getSession().getAttribute("userId");
		int sum = 0;
		int chargePoint = chargeMoney;
		cp.setImpUid(impUid);
		int cpResult = service.cancelPoint(cp);
		user.setChargePoint(chargePoint);
		user.setUserId(userId);
		int uResult = uService.modifycancelChargePoin(user);
		ph.setUserId(userId);
		ph.setPointContents("포인트 환불");
		ph.setPointUse(chargePoint);
		int phResult = service.registerCancelChargePoint(ph);
		sum = cpResult + uResult + phResult;
		if (sum > 2) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('환불 완료되었습니다.')</script>");
			out.println("<script>location.href='chargeList.do';</script>");
		}
	}

	// 아임포트에 토큰 받아오기
	@ResponseBody
	@RequestMapping(value = "getToken.do", method = RequestMethod.POST)
	public String getToken() throws Exception {
		HttpURLConnection conn = null;
		String access_token = null;
		String token = null;
		URL url = new URL("https://api.iamport.kr/users/getToken");
		conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "application/json");
		conn.setRequestProperty("Accept", "application/json");
		conn.setDoOutput(true);
		JSONObject obj = new JSONObject();
		obj.put("imp_key", "5629102220202692");
		obj.put("imp_secret", "e16865ead67733834d03a4bc19b7c3f318bbbfc8cf3291c831bcb78d373a08b8352582d077d5f395");
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
		bw.write(obj.toString());
		bw.flush();
		bw.close();
		int result = 0;
		int responseCode = conn.getResponseCode();
		BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		StringBuilder sb = new StringBuilder();
		if (responseCode == 200) {
			String line = null;
			while ((line = br.readLine()) != null) {
				sb.append(line + "\n");
			}
			br.close();
			access_token = sb.toString();
		} else {
			System.out.println(conn.getResponseMessage());
		}
		conn.disconnect();
		JSONParser jsonParser = new JSONParser();
		JSONObject jsonObj = (JSONObject) jsonParser.parse(access_token);
		if ((Long) jsonObj.get("code") == 0) {
			JSONObject getToken = (JSONObject) jsonObj.get("response");
			token = (String) getToken.get("access_token");
		}
		return token;
	}

	// 아임포트 취소요청.
	@ResponseBody
	@RequestMapping(value = "cancel.do", method = RequestMethod.POST)
	public String calcel(@RequestParam("impUid") String impUid, @RequestParam("chargeMoney") int chargeMoney,
			@RequestParam("token") String token) throws Exception {
		HttpURLConnection conn = null;
		int result = 0;
		URL url = new URL("https://api.iamport.kr/payments/cancel");
		conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "application/json");
		conn.setRequestProperty("Accept", "application/json");
		conn.setRequestProperty("Authorization", token);
		conn.setDoOutput(true);
		JSONObject obj = new JSONObject();
		obj.put("reason", "포인트 환불");
		obj.put("imp_uid", impUid);
		obj.put("amount", chargeMoney);
		obj.put("checksum", chargeMoney);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
		bw.write(obj.toString());
		bw.flush();
		bw.close();
		int responseCode = conn.getResponseCode();
		if (responseCode == 200) {
			result = 1;
			return String.valueOf(result);
		} else {
			System.out.println(result);
			return String.valueOf(result);
		}
	}
}
