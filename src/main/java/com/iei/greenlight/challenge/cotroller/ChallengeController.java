package com.iei.greenlight.challenge.cotroller;

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
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.iei.greenlight.challenge.domain.CFile;
import com.iei.greenlight.challenge.domain.Challenge;
import com.iei.greenlight.challenge.service.ChallengeService;

@Controller
public class ChallengeController {
	
	@Autowired
	private ChallengeService service;

	@RequestMapping(value="ChallengeWriteview.do", method=RequestMethod.GET)
	public String ChallengeWriteView() {
		return "challenge/ChallengeWriteForm";
	}
	
	@RequestMapping(value="ChallengeRegister.do", method=RequestMethod.POST)
	public ModelAndView registerChallenge(
			ModelAndView mv,
			@ModelAttribute Challenge challenge,
			@ModelAttribute CFile cfile,
			@RequestParam(value="uploadFile", required=false) MultipartFile[] uploadFile,
			MultipartHttpServletRequest multirequest) {
		
		String fileName = "";
		String root = multirequest.getSession().getServletContext().getRealPath("resources");
		String savePah = root + "\\cuploadFiles";
		
		File folder = new File(savePah);
		if(!folder.exists()) {
			folder.mkdir();
		}
		String filePath = folder + "\\" + fileName;
		
		for(int i=0; i<uploadFile.length; i++) {
			fileName = uploadFile[i].getOriginalFilename();
			cfile.setFileName(fileName);
			cfile.setFilePath(filePath);
			try {
				uploadFile[i].transferTo(new File(filePath));
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		int result = service.registerChallenge(challenge);
		if (result > 0) {
			mv.setViewName("redirect:ChallengeList.do");
		}else {
			System.out.println("글 등록 실패");
		}
		return mv;
	}
	
}
