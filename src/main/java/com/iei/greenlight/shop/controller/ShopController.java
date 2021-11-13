package com.iei.greenlight.shop.controller;

import java.net.HttpURLConnection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.iei.greenlight.shop.domain.OfflineShop;
import com.iei.greenlight.shop.service.ShopService;

@Controller
public class ShopController {
	
	@Autowired
	private ShopService service;
	
	@RequestMapping(value="offlineShopView.do")
	public String offlineShopView(Model model) {
		
		Gson gson = new Gson();
		
		try {
			List<OfflineShop> sList = service.printOfflineShopList();
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
}
