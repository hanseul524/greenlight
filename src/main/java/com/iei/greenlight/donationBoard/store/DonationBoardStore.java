package com.iei.greenlight.donationBoard.store;

import java.util.HashMap;
import java.util.List;

import com.iei.greenlight.donationBoard.domain.Donation;
import com.iei.greenlight.donationBoard.domain.DonationBoard;
import com.iei.greenlight.donationBoard.domain.DonationReply;
import com.iei.greenlight.donationBoard.domain.DtFile;
import com.iei.greenlight.donationBoard.domain.PageInfo;

public interface DonationBoardStore {

	int insertDonationBoard(DonationBoard db);

	int insertDtFile(List<DtFile> dFile);

	int getListCount();

	List<DonationBoard> selectDonationBoardAllList(PageInfo pi);

	DonationBoard selectDonationBoardOne(int boardNo);

	List<DtFile> selectAllDonationBoardImageOneByNo(int boardNo);

	int donationUserPoint(HashMap<String, Object> map);

	void insertDonationUser(Donation donation);

	void updateDonationBoardDonationAmount(DonationBoard db);

	List<Donation> selectDonationUserRanking(int boardNo);

	public List<DonationBoard> mySelectList(HashMap<String, Object> hashMap);

	int insertDonationReply(DonationReply donationReply);

	void updateBoardReplyCound(int boardNo);

	List<DonationReply> seelectAllReply(int boardNo);

	int updateBoardReplyContents(DonationReply donationReply);

	int deleteDonationReply(DonationReply donationReply);

	int selectSearchDonationListCount(String searchKey);

	List<DonationBoard> selectDonationBoardSearchList(HashMap<String, Object> hashMap);

	int selectAdminDonationCount();

	List<DonationBoard> selectAllAdminBoard(PageInfo pi);
}
