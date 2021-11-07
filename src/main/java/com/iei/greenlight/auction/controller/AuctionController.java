package com.iei.greenlight.auction.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.iei.greenlight.auction.domain.Auction;
import com.iei.greenlight.auction.domain.AuctionImage;
import com.iei.greenlight.auction.service.AuctionService;

@Controller
public class AuctionController {
	
	 @Autowired
	 private AuctionService service;
	
	// 리스트 페이지 이동
	@RequestMapping(value="auctionListView.do")
	public String auctionListView(HttpServletRequest request, Model model) {
		
		try {
			List<Auction> aList = service.printAllList();
			if(!aList.isEmpty()) {
				model.addAttribute("aList", aList);
				return "auction/auctionList";
			}else {
				model.addAttribute("aList", null);
				return "common/errorPage";
			}
		}catch(Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", e.toString());
			return "common/errorPage";
		}
	}
	
	// 경매 신청글 페이지 이동
	@RequestMapping(value="auctionWrite.do")
	public String auctionWriteView() {
		
		return "auction/auctionWrite";
		
	}
	
	
	// 경매 신청
	@RequestMapping(value="auctionApply.do", method=RequestMethod.POST)
	public String auctionApply(@ModelAttribute Auction auction, HttpServletRequest request, Model model, @RequestParam("uploadFiles") MultipartFile[] uploadFiles) {
		
		
		auction.setUserId((String)request.getSession().getAttribute("userId")); // session값에서 아이디 가지고 오기
		List<AuctionImage> aList = null;
		
		try {
			int result = service.registerAuction(auction); // insert 됐을 시 auctionNo 을 가져와야되
			if(result > 0) {
				aList = new ArrayList<AuctionImage>();
				for(MultipartFile uploadFile : uploadFiles) {
					if(!uploadFile.getOriginalFilename().equals("")) {
						AuctionImage auctionImage = saveFile(uploadFile, request);
						auctionImage.setAuctionNo(auction.getAuctionNo()); // selectKey를 이용한 primaryKey 값 가져오기
						auctionImage.setUserId("user01"); // 임의 아이디
						auctionImage.setFileSize(uploadFile.getSize());
						auctionImage.setFileMain("N");
						aList.add(auctionImage);
					}
				}
				aList.get(0).setFileMain("Y"); // 첫번째 사진 mainImage 등록
				int image = service.registerAuctionImage(aList);
				return "redirect:auctionListView.do";
			}else {
				model.addAttribute("msg", "경매 신청글 실패");
				return "common/errorPage";
			}
			
		}catch(Exception e) {
			model.addAttribute("msg", e.toString());
			return "common/errorPage";
		}
		
	}
	
	// 경매 신청 파일 저장
	public AuctionImage saveFile(MultipartFile uploadFile, HttpServletRequest request) {
		
		String root = request.getSession().getServletContext().getRealPath("resources");
		String savePath = root + "\\auctionImage"; // 경로 생성
		File folder= new File(savePath);
		if(!folder.exists()) {
			folder.mkdir(); // 폴더생성
		}
		
		String filePath = folder + "\\" + uploadFile.getOriginalFilename(); // 파일 절대 경로
		String fileName = uploadFile.getOriginalFilename();
		
		
		try {
			uploadFile.transferTo(new File(filePath)); // 파일 업로드
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		AuctionImage auctionImage = new AuctionImage(fileName, filePath);
		return auctionImage;
		
	}

}
