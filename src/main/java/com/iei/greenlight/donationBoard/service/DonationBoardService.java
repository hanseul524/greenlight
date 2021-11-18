package com.iei.greenlight.donationBoard.service;

import java.util.List;

import com.iei.greenlight.donationBoard.domain.DonationBoard;
import com.iei.greenlight.donationBoard.domain.DtFile;
import com.iei.greenlight.donationBoard.domain.PageInfo;

public interface DonationBoardService {

	int registerdonationBoard(DonationBoard db);

	int registerDtFile(List<DtFile> dFile);

	int getListCount();

	List<DonationBoard> printAll(PageInfo pi);

}
