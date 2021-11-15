package com.iei.greenlight.donationBoard.store;

import com.iei.greenlight.donationBoard.domain.DonationBoard;
import com.iei.greenlight.donationBoard.domain.DtFile;

public interface DonationBoardStore {

	int insertDonationBoard(DonationBoard db);

	int insertDtFile(DtFile dtFile);

}
