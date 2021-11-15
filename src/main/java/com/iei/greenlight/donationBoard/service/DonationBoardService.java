package com.iei.greenlight.donationBoard.service;

import com.iei.greenlight.donationBoard.domain.DonationBoard;
import com.iei.greenlight.donationBoard.domain.DtFile;

public interface DonationBoardService {

	int registerdonationBoard(DonationBoard db);

	int registerDtFile(DtFile dtFile);

}
