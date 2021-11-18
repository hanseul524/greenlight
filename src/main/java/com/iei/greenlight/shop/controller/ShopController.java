package com.iei.greenlight.shop.controller;

import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;
import com.iei.greenlight.auction.domain.AdminPageInfo;
import com.iei.greenlight.auction.domain.PageInfo;
import com.iei.greenlight.common.AdminAuctionPagination;
import com.iei.greenlight.common.OfflineShopPagination;
import com.iei.greenlight.shop.domain.OfflinePageInfo;
import com.iei.greenlight.shop.domain.OfflineShop;
import com.iei.greenlight.shop.service.ShopService;

@Controller
public class ShopController {
	
	@Autowired
	private ShopService service;
	
	// 오프라인 매장 지도페이지
	@RequestMapping(value="offlineShopView.do")
	public String offlineShopView(Model model, @RequestParam(value="page", required=false) Integer page) {
		
		Gson gson = new Gson();
		
		try {
			int currentPage = (page != null) ? page : 1;
			int totalCount = service.getOfflineListCount();
			OfflinePageInfo pi = OfflineShopPagination.getPageInfo(currentPage, totalCount);
			System.out.println("오프라인샵 페이지 : " + pi.toString());
			List<OfflineShop> sList = service.printOfflineShopList(pi);
			System.out.println(sList.size());
			if(!sList.isEmpty()) {
				model.addAttribute("pi", pi);
				model.addAttribute("sList", gson.toJson(sList));
				return "shop/offlineShop";
			}else {
				model.addAttribute("sList", null);
				return "shop/offlineShop";
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.toString());
			return "common/errorPage";
		}
	}
	
	
	// 오프라인 매장 디테일 페이지
	@RequestMapping(value="offlineShopDetail.do")
	public String offlineShopDetail(@RequestParam("shopNo") int shopNo, Model model) {
		
		try {
			OfflineShop offlineShop = service.printOfflineOneByNo(shopNo);
			if(offlineShop != null) {
				System.out.println(offlineShop.toString());
				model.addAttribute("offlineShop", offlineShop);
				return "shop/offlineDetail";
			}else {
				model.addAttribute("msg", "오프라인 샵 실패");
				return "common/errorPage";
			}
		}catch(Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.toString());
			return "common/errorPage";
		}
	}
	
	// 지도 검색
	@RequestMapping(value="offlineSearch.do", method=RequestMethod.POST)
	public String offlineSearchList(@RequestParam("searchKeyWord") String searchKeyWord, Model model) {
		
		Gson gson = new Gson();
		try {
			List<OfflineShop> sList = service.printOfflineSearchList(searchKeyWord);
			System.out.println(sList.size());
			if(!sList.isEmpty()) {
				model.addAttribute("sList", gson.toJson(sList));
				return "shop/offlineShop";
			}else {
				model.addAttribute("sList", null);
				return "shop/offlineShop";
			}
		}catch(Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.toString());
			return "common/errorPage";
		}
	}
	
	// 관리자 오프라인 매장 리스트
	@RequestMapping(value="adminOfflineShop.do", method=RequestMethod.GET)
	public String adminOfflineShop(Model model, @RequestParam(value="page", required=false) Integer page) {
		
		try {
			int currentPage = (page != null) ? page : 1;
			int totalCount = service.getOfflineListCount();
			OfflinePageInfo pi = OfflineShopPagination.getPageInfo(currentPage, totalCount);
			List<OfflineShop> sList = service.printOfflineShopList(pi);
			if(!sList.isEmpty()) {
				model.addAttribute("pi", pi);
				model.addAttribute("sList", sList);
				return "admin/adminOfflineShop";
			}else {
				model.addAttribute("sList", null);
				return "admin/adminOfflineShop";
			}
		}catch(Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.toString());
			return "common/errorPage";
		}
	}
	
	// 관리자 오프라인 매장 삭제
	@RequestMapping(value="deleteOfflineShop.do", method=RequestMethod.POST)
	public String deleteOfflineShop(@RequestParam("shopNo") int[] shopNo, Model model) {
		
		for(int i = 0; i < shopNo.length; i++) {
			System.out.println(shopNo[i]);
		}
		
		try {
			int result = service.removeOfflineShop(shopNo);
			if(result > 0) {
				return "redirect:adminOfflineShop.do";
			}else {
				model.addAttribute("msg", "삭제 실패!");
				return "common/errorPage";
			}
		}catch(Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.toString());
			return "common/errorPage";
		}
	}
	
	// 관리자 오프라인매장 등록 페이지 이동
	@RequestMapping(value="insertOfflineShop.do")
	public String insertOfflineShop() {
		
		return "admin/adminOfflineShopWriteView";
	}
	
}
