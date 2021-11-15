package com.iei.greenlight.donationBoard.store.logic;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iei.greenlight.donationBoard.domain.DonationBoard;
import com.iei.greenlight.donationBoard.domain.DtFile;
import com.iei.greenlight.donationBoard.store.DonationBoardStore;

@Repository
public class DonationBoardLogic implements DonationBoardStore{

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public int insertDonationBoard(DonationBoard db) {
		return sqlSession.insert("donationBoardMapper.insertDonationBoard", db);
	}

	@Override
	public int insertDtFile(DtFile dtFile) {
		return sqlSession.insert("donationBoardMapper.insertDtFile", dtFile);
	}

}
