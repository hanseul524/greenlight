package com.iei.greenlight.donationBoard.store.logic;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iei.greenlight.donationBoard.domain.DonationBoard;
import com.iei.greenlight.donationBoard.domain.DtFile;
import com.iei.greenlight.donationBoard.domain.PageInfo;
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
	public int insertDtFile(List<DtFile> dFile) {
		return sqlSession.insert("donationBoardMapper.insertDtFile", dFile);
	}

	@Override
	public int getListCount() {
		return sqlSession.selectOne("donationBoardMapper.selectListCount");
	}

	@Override
	public List<DonationBoard> selectDonationBoardAllList(PageInfo pi) {
		int offset = (pi.getCurrentPage()-1) * pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		return sqlSession.selectList("donationBoardMapper.selectDonationBoardAllList", pi, rowBounds);
	}

}
