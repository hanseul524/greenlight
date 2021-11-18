package com.iei.greenlight.donationBoard.controller;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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

import com.iei.greenlight.donationBoard.common.donationBoardPagination;
import com.iei.greenlight.donationBoard.domain.DonationBoard;
import com.iei.greenlight.donationBoard.domain.DtFile;
import com.iei.greenlight.donationBoard.domain.PageInfo;
import com.iei.greenlight.donationBoard.service.DonationBoardService;

@Controller
public class DonationBoardController {

	@Autowired
	private DonationBoardService service;
	// 기부게시판 글 작성 view
	@RequestMapping(value="donationBoardWriteView.do", method=RequestMethod.GET)
	public String donationBoardWriteView() {
		return "donation/donationBoardWrite";
	}
	
	// 기부게시글 등록
	@RequestMapping(value="donationboardWrite.do", method=RequestMethod.POST)
	public String donationBoardWrite(@ModelAttribute DonationBoard db, @RequestParam("editordata") String dtContents, @RequestParam("uploadFile") MultipartFile[] uploadFiles,HttpServletRequest request) {
		db.setDtContents(dtContents);
		db.setWriterId((String)request.getSession().getAttribute("userId"));
		List<DtFile> dFList = null;
		int result = service.registerdonationBoard(db);
		int boardNo = db.getBoardNo();
		
		if(result > 0) {
			dFList = new ArrayList<DtFile>();
			for(MultipartFile uploadFile : uploadFiles) {
				if(!uploadFile.getOriginalFilename().equals("")) {
					DtFile dt = saveFile(uploadFile, request,boardNo);
					dt.setFileMain("N");
					dFList.add(dt);
				}
			}
			dFList.get(0).setFileMain("Y");
			int image = service.registerDtFile(dFList);
			return "redirect:main.do";
		}else {
			return"user/error";
		}
	}
	
	// 이클립스 파일 저장.
	public DtFile saveFile(MultipartFile uploadFile, HttpServletRequest request, int boardNo) {
		String root = request.getSession().getServletContext().getRealPath("resources");
		String savePath = root + "\\donationUploadFiles";
		File folder = new File(savePath);
		DtFile dtFile = new DtFile();
		if(!folder.exists()) {
			folder.mkdir();
		}
		String filePath = folder + "\\" + uploadFile.getOriginalFilename();
		String fileName = uploadFile.getOriginalFilename();
		
		try {
			uploadFile.transferTo(new File(filePath));
		}catch(IllegalStateException e){
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			dtFile.setBoardNo(boardNo);
			dtFile.setFileName(fileName);
			dtFile.setFilePath(filePath);
			dtFile.setFileSize(uploadFile.getSize());
		}
		return dtFile;
	}
	
	@RequestMapping(value="donationBoardList.do", method=RequestMethod.GET)
	public String donationBoardListView(Model model, HttpServletRequest request, @RequestParam(value="page", required=false) Integer page) {
		int currentPage = (page != null) ? page : 1;
		int totalCount = service.getListCount();
		PageInfo pi = donationBoardPagination.getPageInfo(currentPage, totalCount);
		List<DonationBoard> dList = service.printAll(pi);
		if(!dList.isEmpty()) {
			model.addAttribute("dList", dList);
			model.addAttribute("pi", pi);
			return "donation/donationBoardList";
		}else {
			return "user/error";
		}
		
	}
}
