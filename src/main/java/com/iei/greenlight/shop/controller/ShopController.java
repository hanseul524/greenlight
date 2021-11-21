package com.iei.greenlight.shop.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.iei.greenlight.auction.domain.AdminPageInfo;
import com.iei.greenlight.auction.domain.PageInfo;
import com.iei.greenlight.common.AdminAuctionPagination;
import com.iei.greenlight.common.AdminOfflineShopPagination;
import com.iei.greenlight.common.OfflineShopPagination;
import com.iei.greenlight.common.OnlineShopPagination;
import com.iei.greenlight.shop.domain.OfflinePageInfo;
import com.iei.greenlight.shop.domain.OfflineShop;
import com.iei.greenlight.shop.domain.OnlinePageInfo;
import com.iei.greenlight.shop.domain.OnlineShop;
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
			List<OfflineShop> sList = service.printOfflineShopList(pi);
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
	public String offlineSearchList(@RequestParam("searchKeyWord") String searchKeyWord, Model model, @RequestParam(value="page", required=false) Integer page) {
		
		Gson gson = new Gson();
		HashMap<String, Object> hashmap = new HashMap<String, Object>();
		try {
			int currentPage = (page != null) ? page : 1;
			int totalCount = service.getSearchOfflineListCount(searchKeyWord);
			System.out.println(searchKeyWord);
			OfflinePageInfo pi = OfflineShopPagination.getPageInfo(currentPage, totalCount);
			hashmap.put("pi", pi);
			hashmap.put("searchKeyWord", searchKeyWord);
			List<OfflineShop> sList = service.printOfflineSearchList(hashmap);
			System.out.println("지도 검색 size : " + sList.size());
			if(!sList.isEmpty()) {
				model.addAttribute("sList", gson.toJson(sList));
				model.addAttribute("pi", pi);
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
			OfflinePageInfo pi = AdminOfflineShopPagination.getPageInfo(currentPage, totalCount);
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
	
	// 관리자 매장 검색 리스트
	@RequestMapping(value="adminSearchOfflineShopList.do", method=RequestMethod.GET)
	public String adminOfflineShopSearchList(Model model, @RequestParam("searchKeyword") String searchKeyWord, @RequestParam(value="page", required=false) Integer page) {
		
		HashMap<String, Object> hashmap = new HashMap<String, Object>();
		
		try {
			int currentPage = (page != null) ? page : 1;
			int totalCount = service.getSearchOfflineListCount(searchKeyWord);
			OfflinePageInfo pi = AdminOfflineShopPagination.getPageInfo(currentPage, totalCount);
			hashmap.put("pi", pi);
			hashmap.put("searchKeyWord", searchKeyWord);
			List<OfflineShop> sList = service.printOfflineSearchList(hashmap);
			if(!sList.isEmpty()) {
				model.addAttribute("pi", pi);
				model.addAttribute("searchKeyWord", searchKeyWord);
				model.addAttribute("sList", sList);
				return "admin/adminSearchOfflineShop";
			}else {
				model.addAttribute("sList", null);
				return "admin/adminSearchOfflineShop";
			}
		}catch(Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.toString());
			return "common/errorPage";
		}
	}
	
	// 관리자 오프라인매장 디테일 페이지 이동
	@RequestMapping(value="offlineShopDetailView.do")
	public String offlineShopDetailView(int shopNo, Model model) {
		
		try {
			OfflineShop offlineShop = service.printOfflineOneByNo(shopNo);
			if(offlineShop != null) {
				model.addAttribute("offlineShop", offlineShop);
				return "admin/adminOfflineShopDetailView";
			}else {
				model.addAttribute("msg", "오프라인 매장 조회 실패");
				return "common/errorPage";
			}
		}catch(Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.toString());
			return "common/errorPage";
		}
	}

	
	// 관리자 오프라인매장 등록 페이지 이동
	@RequestMapping(value="OfflineShopWriteView.do")
	public String offlineWriteView() {
		
		return "admin/adminOfflineShopWriteView";
	}
	
	// 관리자 오프라인매장 등록
	@RequestMapping(value="insertOfflineShop.do", method=RequestMethod.POST)
	public String insertOfflineShop(Model model, @ModelAttribute OfflineShop offlineShop) {
		
		try {
			int result = service.registerOfflineShop(offlineShop);
			if(result > 0) {
				return "redirect:adminOfflineShop.do";
			}else {
				model.addAttribute("msg", "업로드 실패");
				return "common/errorPage";
			}
		}catch(Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.toString());
			return "common/errorPage";
		}
	}
	
	// 관리자 오프라인 매장 수정 페이지
	@RequestMapping(value="offlineShopUpdateWriteView.do")
	public String offlineShopUpdateWriteView(@RequestParam("shopNo") int shopNo, Model model) {
		
		OfflineShop offlineShop = service.printOfflineOneByNo(shopNo);
		if(offlineShop != null) {
			model.addAttribute("offlineShop", offlineShop);
			return "admin/adminOfflineShopUpdateView";
		}else {
			model.addAttribute("msg", "조회 실패");
			return "common/errorPage";
		}
	}
	
	//관리자 오프라인 매장 수정
	@RequestMapping(value="updateOfflineShop.do", method=RequestMethod.POST)
	public String updateOfflineShop(Model model, @ModelAttribute OfflineShop offlineShop) {
		
		try {
			System.out.println(offlineShop.toString());
			int result = service.modifyOfflineShop(offlineShop);
			if(result > 0) {
				return "redirect:offlineShopDetailView.do?shopNo="+offlineShop.getShopNo();
			}else {
				model.addAttribute("msg", "수정 실패!");
				return "common/errorPage";
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
	
	//---------------------------------------------------------------------------------------------------------//
	
	// ZeroWaste Shop List
	@RequestMapping(value="onlineShopView.do")
	public String onlineShopView(Model model, @RequestParam(value="page", required=false) Integer page) {
		
		try {
			int currentPage = (page != null) ? page : 1;
			int totalCount = service.getZeroWasteListCount();
			OnlinePageInfo pi = OnlineShopPagination.getPageInfo(currentPage, totalCount);
			List<OnlineShop> sList = service.printZeroWasteShopList(pi);
			if(!sList.isEmpty()) {
				model.addAttribute("pi", pi);
				model.addAttribute("sList", sList);
				return "shop/zerowasteShop";
			}else {
				model.addAttribute("sList", null);
				return "shop/zerowasteShop";
			}
		}catch(Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.toString());
			return "common/errorPage";
		}
		
	}
	
	// upCycling List
	@RequestMapping(value="upCyclingView.do")
	public String upCyclingView(Model model, @RequestParam(value="page", required=false) Integer page) {
		
		try {
			int currentPage = (page != null) ? page : 1;
			int totalCount = service.getUpCyclingListCount(); 
			OnlinePageInfo pi = OnlineShopPagination.getPageInfo(currentPage, totalCount);
			List<OnlineShop> sList = service.printUpCyclingShopList(pi);
			if(!sList.isEmpty()) {
				model.addAttribute("sList", sList);
				model.addAttribute("pi", pi);
				return "shop/upcyclingShop";
			}else {
				model.addAttribute("sList", null);
				return "shop/upcyclingShop";	
			}
		}catch(Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.toString());
			return "common/errorPage";
		}
	}
	
	// 관리자 온라인매장 페이지
	@RequestMapping(value="adminOnlineShop.do")
	public String adminOnlineView(Model model, @RequestParam(value="page", required=false) Integer page) {
		
		try {
			int currentPage = (page != null) ? page : 1;
			int totalCount = service.getOnlineListCount();
			OfflinePageInfo pi = AdminOfflineShopPagination.getPageInfo(currentPage, totalCount);
			List<OnlineShop> sList = service.printOnlineShopList(pi);
			if(!sList.isEmpty()) {
				model.addAttribute("pi", pi);
				model.addAttribute("sList", sList);
				return "admin/adminOnlineShop";
			}else {
				model.addAttribute("sList", null);
				return "admin/adminOnlineShop";
			}
		}catch(Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.toString());
			return "common/errorPage";
		}
		
	}
	
	// 관리자 온라인 검색 리스트
	@RequestMapping(value="adminSearchOnlineShopList.do", method=RequestMethod.POST)
	public String adminOnlineSearchList(@RequestParam("searchKeyWord") String searchKeyWord, Model model,@RequestParam(value="page", required=false) Integer page) {
		
		int currentPage = (page != null) ? page : 1;
		int totalCount = service.getOnlineSearchListCount(searchKeyWord);
		OfflinePageInfo pi = AdminOfflineShopPagination.getPageInfo(currentPage, totalCount);
		HashMap<String, Object> hashmap = new HashMap<String, Object>();
		hashmap.put("pi", pi);
		hashmap.put("searchKeyWord", searchKeyWord);
		List<OnlineShop> sList = service.printOnlineShopSearchList(hashmap);
		if(!sList.isEmpty()) {
			model.addAttribute("searchKeyWord", searchKeyWord);
			model.addAttribute("sList", sList);
			model.addAttribute("pi", pi);
			return "admin/adminOnlineSearchShop";
		}else {
			model.addAttribute("sList", null);
			return "admin/adminOnlineSearchShop";
		}
	}
	
	// 관리자 온라인매장 등록 페이지
	@RequestMapping(value="onlineShopWriteView.do")
	public String adminOnlineWriteView() {
		return "admin/adminOnlineShopWriteView";
	}
	
	// 관리자 온라인매장 등록
	@RequestMapping(value="insertOnlineShop.do", method=RequestMethod.POST)
	public String insertOnlineShop(Model model, @ModelAttribute OnlineShop onlineShop, HttpServletRequest request, @RequestParam("uploadFile") MultipartFile uploadFile) {
		
		try {
			if(!uploadFile.getOriginalFilename().equals("")) {
				String shopImage = saveFile(uploadFile, request);
				if(shopImage != null) {
					onlineShop.setShopImage(shopImage);
				}
			}
			int result = service.registerOnlineShop(onlineShop);
			if(result > 0) {
				return "redirect:adminOnlineShop.do";
			}else {
				model.addAttribute("msg", "매장 등록 실패");
				return "common/errorPage";
			}
		}catch(Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.toString());
			return "common/errorPage";
		}
		
	}
	
	// 관리자 온라인 매장 디테일 페이지 이동
	@RequestMapping(value="onlineShopDetailView.do")
	public String onlineShopDetailView(int shopNo, Model model) {
		
		try {
			OnlineShop onlineShop = service.printOnlineShopOneByNo(shopNo);
			if(onlineShop != null) {
				model.addAttribute("onlineShop", onlineShop);
				return "admin/adminOnlineShopDetailView";
			}else {
				model.addAttribute("msg", "온라인 매장 조회 실패");
				return "common/errorPage";
			}
		}catch(Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.toString());
			return "common/errorPage";
		}
	}
	
	// 관리자 온라인 매장 수정 페이지 이동
	@RequestMapping(value="onlineShopUpdateWriteView.do")
	public String onlineShopUpdateWriteView(Model model, int shopNo) {
		
		try {
			OnlineShop onlineShop = service.printOnlineShopOneByNo(shopNo);
			if(onlineShop != null) {
				model.addAttribute("onlineShop", onlineShop);
				return "admin/adminOnlineShopUpdateView";
			}else {
				model.addAttribute("msg", "온라인 매장 조회 실패!");
				return "common/errorPage";
			}
		}catch(Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.toString());
			return "common/errorPage";
		}
	}
	
	// 관리자 온라인 매장 수정
	@RequestMapping(value="updateOnlineShop.do", method=RequestMethod.POST)
	public String updateOnlineShop(@ModelAttribute OnlineShop onlineShop, Model model, HttpServletRequest request, @RequestParam("uploadFile") MultipartFile uploadFile) {
		
		try {
			deleteFile(onlineShop.getShopImage(), request);
			saveFile(uploadFile, request);
			onlineShop.setShopImage(uploadFile.getOriginalFilename());
			int result = service.modifyOnlineShop(onlineShop);
			if(result > 0) {
				model.addAttribute("onlineShop", onlineShop);
				return "redirect:onlineShopDetailView.do?shopNo="+onlineShop.getShopNo();
			}else {
				model.addAttribute("msg", "온라인 매장 수정 실패");
				return "common/errorPage";
			}
		}catch(Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.toString());
			return "common/errorPage";
		}
	}
	
	// 관리자 온라인 매장 삭제
	@RequestMapping(value="deleteOnlineShop.do", method=RequestMethod.POST)
	public String deleteOnlineShop(Model model, @RequestParam("shopNo") int[] shopNo, HttpServletRequest request) {
		
		HashMap<String, int[]> hashmap = new HashMap<String, int[]>();
		hashmap.put("shopNo", shopNo);
		
		try {
			List<OnlineShop> sList = service.printOnlineShopOneByNo(hashmap);
			for(OnlineShop o : sList) {
				deleteFile(o.getShopImage(), request);
			}
			int result = service.removeOnlineShop(shopNo);
			if (result > 0) {
				return "redirect:adminOnlineShop.do";
			} else {
				model.addAttribute("msg", "온라인샵 삭제 실패!");
				return "common/errorPage";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.toString());
			return "common/errorPage";
		}
		 
	}
	
	// 파일저장
	public String saveFile(MultipartFile uploadFile, HttpServletRequest request) {
		
		String root = request.getSession().getServletContext().getRealPath("resources");
		String savePath = root + "\\shopUploadFiles";
		File folder = new File(savePath);
		if(!folder.exists()) {
			folder.mkdir();
		}
		
		String filePath = folder + "\\" + uploadFile.getOriginalFilename();
		
		try {
			uploadFile.transferTo(new File(filePath));
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return uploadFile.getOriginalFilename();
	}
	
	public void deleteFile(String fileName, HttpServletRequest request) {
		
		String root = request.getSession().getServletContext().getRealPath("resources");
		String fullPath = root + "\\shopUploadFiles";
		File file = new File(fullPath + "\\" + fileName);
		if(file.exists()) {
			file.delete();
		}
		
	}
	
}
