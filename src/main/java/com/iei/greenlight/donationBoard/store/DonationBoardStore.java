package com.iei.greenlight.donationBoard.store;

import java.util.List;

import com.iei.greenlight.donationBoard.domain.DonationBoard;
import com.iei.greenlight.donationBoard.domain.DtFile;
import com.iei.greenlight.donationBoard.domain.PageInfo;

public interface DonationBoardStore {

	int insertDonationBoard(DonationBoard db);

	int insertDtFile(List<DtFile> dFile);

	int getListCount();

	List<DonationBoard> selectDonationBoardAllList(PageInfo pi);

}
