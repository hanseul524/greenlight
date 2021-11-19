package com.iei.greenlight.donationBoard.service;

import java.util.HashMap;
import java.util.List;

import com.iei.greenlight.donationBoard.domain.Donation;
import com.iei.greenlight.donationBoard.domain.DonationBoard;
import com.iei.greenlight.donationBoard.domain.DonationReply;
import com.iei.greenlight.donationBoard.domain.DtFile;
import com.iei.greenlight.donationBoard.domain.PageInfo;

public interface DonationBoardService {

	int registerdonationBoard(DonationBoard db);

	int registerDtFile(List<DtFile> dFile);

	int getListCount();

	List<DonationBoard> printAll(PageInfo pi);

	DonationBoard printDonationBoardOne(int boardNo);

	List<DtFile> printAllDonationBoardImageOneByNo(int boardNo);

	int donationUserPoint(HashMap<String, Object> map);

	void registerDonation(Donation donation);

	void updateDonationBoardDonationAmount(DonationBoard db);

	List<Donation> printDonationUserRanking(int boardNo);

	public List<DonationBoard> myPrintList(HashMap<String, Object> hashMap);

	int registerReply(DonationReply donationReply);

	void modifyReplyCount(int boardNo);

	List<DonationReply> printAllReply(int boardNo);
}
