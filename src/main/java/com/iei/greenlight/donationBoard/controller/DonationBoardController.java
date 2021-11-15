package com.iei.greenlight.donationBoard.controller;


import java.io.File;
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
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.iei.greenlight.donationBoard.domain.DonationBoard;
import com.iei.greenlight.donationBoard.domain.DtFile;
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
	public String donationBoardWrite(@ModelAttribute DonationBoard db, Model model, @RequestParam("editordata") String dtContents, MultipartHttpServletRequest multirequest,HttpServletRequest request) {
		db.setDtContents(dtContents);
		int result = service.registerdonationBoard(db);
		int boardNo = db.getBoardNo();
		int sum = 0;
		if(result > 0) {
			return "redirect:main.do";
		}else {
			return "user/error";
		}

	}
	
	// 이클립스 파일 저장.
	public int saveFile(MultipartFile uploadFile, HttpServletRequest request, int boardNo) {
		String root = request.getSession().getServletContext().getRealPath("resources");
		String savePath = root + "\\donationUploadFiles";
		File folder = new File(savePath);
		int result = 0;
		if(!folder.exists()) {
			folder.mkdir();
		}
		String filePath = folder + "\\" + uploadFile.getOriginalFilename();
		
		try {
			// 이클립스 파일 저장
			uploadFile.transferTo(new File(filePath));
			// 데이터베이스 파일 저장
			DtFile dtFile = new DtFile();
			dtFile.setBoradNo(boardNo);
			dtFile.setFileName(uploadFile.getOriginalFilename());
			dtFile.setFilePath(savePath);
			dtFile.setFileSize(uploadFile.getSize());
			result = service.registerDtFile(dtFile);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
