package com.iei.greenlight.donationBoard.service.logic;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iei.greenlight.donationBoard.domain.Donation;
import com.iei.greenlight.donationBoard.domain.DonationBoard;
import com.iei.greenlight.donationBoard.domain.DonationReply;
import com.iei.greenlight.donationBoard.domain.DtFile;
import com.iei.greenlight.donationBoard.domain.PageInfo;
import com.iei.greenlight.donationBoard.service.DonationBoardService;
import com.iei.greenlight.donationBoard.store.DonationBoardStore;

@Service
public class DonationBoardServiceImpl implements DonationBoardService{

	@Autowired
	private DonationBoardStore store;
	
	@Override
	public int registerdonationBoard(DonationBoard db) {
		return store.insertDonationBoard(db);
	}

	@Override
	public int registerDtFile(List<DtFile> dFile) {
		return store.insertDtFile(dFile);
	}

	@Override
	public int getListCount() {
		return store.getListCount();
	}

	@Override
	public List<DonationBoard> printAll(PageInfo pi) {
		return store.selectDonationBoardAllList(pi);
	}

	@Override
	public DonationBoard printDonationBoardOne(int boardNo) {
		return store.selectDonationBoardOne(boardNo);
	}

	@Override
	public List<DtFile> printAllDonationBoardImageOneByNo(int boardNo) {
		return store.selectAllDonationBoardImageOneByNo(boardNo);
	}

	@Override
	public int donationUserPoint(HashMap<String, Object> map) {
		return store.donationUserPoint(map);
	}

	@Override
	public void registerDonation(Donation donation) {
		store.insertDonationUser(donation);
	}

	@Override
	public void updateDonationBoardDonationAmount(DonationBoard db) {
		store.updateDonationBoardDonationAmount(db);
	}

	@Override
	public List<Donation> printDonationUserRanking(int boardNo) {
		return store.selectDonationUserRanking(boardNo);
	}

	//마이페이지 내가 기부한 기부글 리스트
	   public List<DonationBoard> myPrintList(HashMap<String, Object> hashMap) {
	      return store.mySelectList(hashMap);
	   }

	@Override
	public int registerReply(DonationReply donationReply) {
		return store.insertDonationReply(donationReply);
	}

	@Override
	public void modifyReplyCount(int boardNo) {
		store.updateBoardReplyCound(boardNo);
	}

	@Override
	public List<DonationReply> printAllReply(int boardNo) {
		return store.seelectAllReply(boardNo);
	}

	@Override
	public int modifyReplyContents(DonationReply donationReply) {
		return store.updateBoardReplyContents(donationReply);
	}

	@Override
	public int donationRemoveReply(DonationReply donationReply) {
		return store.deleteDonationReply(donationReply);
	}

	@Override
	public int getSearchDonationListCount(String searchKey) {
		return store.selectSearchDonationListCount(searchKey);
	}

	@Override
	public List<DonationBoard> printDonationSearchList(HashMap<String, Object> hashMap) {
		return store.selectDonationBoardSearchList(hashMap);
	}

	@Override
	public int getAdminDonationListCount() {
		return store.selectAdminDonationCount();
	}

	@Override
	public List<DonationBoard> printAdminboardAll(PageInfo pi) {
		return store.selectAllAdminBoard(pi);
	}
}
