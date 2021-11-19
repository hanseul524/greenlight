package com.iei.greenlight.donationBoard.store.logic;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iei.greenlight.donationBoard.domain.Donation;
import com.iei.greenlight.donationBoard.domain.DonationBoard;
import com.iei.greenlight.donationBoard.domain.DonationReply;
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

	@Override
	public DonationBoard selectDonationBoardOne(int boardNo) {
		return sqlSession.selectOne("donationBoardMapper.selectDonationOne", boardNo);
	}

	@Override
	public List<DtFile> selectAllDonationBoardImageOneByNo(int boardNo) {
		return sqlSession.selectList("donationBoardMapper.selectDonationBoardImageList",boardNo);
	}

	@Override
	public int donationUserPoint(HashMap<String, Object> map) {
		String userId = (String)map.get("userId");
		int dPoint = Integer.parseInt(String.valueOf(map.get("donationPoint")));
		// 포인트
		int point = sqlSession.selectOne("donationBoardMapper.selectUserPoint", userId);
		int result = sqlSession.update("donationBoardMapper.donationUserPoint", map);
		// point차감 후 잔액 확인
		int userPoint = sqlSession.selectOne("donationBoardMapper.selectUserPoint", userId);
		if(userPoint < 0) {
			String pointContents = "기부";
			HashMap<String, Object> hMap = new HashMap<String, Object>();
			hMap.put("point", point);
			hMap.put("userId", userId);
			hMap.put("pointContents", pointContents);
			if(point != 0 && point - dPoint< 0) {
				// 히스토리 일반 포인트
				sqlSession.insert("donationBoardMapper.insertNormalPointHistory", hMap);
			}
			int cPoint = -(userPoint);
			hMap.put("cPoint", cPoint);
			// 히스토리 충전포인트 차감내역
			sqlSession.insert("donationBoardMapper.insertUseChargePointHistory", hMap);
			// point가 마이너스이면 히스토리에 2번 등록 그럼 point값 chargePoint값 두개 등록.
			// 즉, point의 값을 가져와야 한다.
			sqlSession.update("donationBoardMapper.updateUserPointZero", userId);
			HashMap<String, Object> cMap = new HashMap<String, Object>(); // 충전 포인트 차감하기 위한 맵
			cMap.put("donationPoint", userPoint);
			cMap.put("userId", userId);
			sqlSession.update("donationBoardMapper.updateUserChargePoint", cMap);
		}else {
			String pointContents = "기부(지급 포인트)";
			map.put("pointContents", pointContents);
			sqlSession.insert("donationBoardMapper.insertdonationPointHistory", map);
		}
		return result;
	}

	@Override
	public void insertDonationUser(Donation donation) {
		sqlSession.insert("donationBoardMapper.insertDonationUser", donation);
	}

	@Override
	public void updateDonationBoardDonationAmount(DonationBoard db) {
		sqlSession.update("donationBoardMapper.updateDonationBoardDonationAmount", db);
	}

	@Override
	public List<Donation> selectDonationUserRanking(int boardNo) {
		return sqlSession.selectList("donationBoardMapper.selectDonationUserRanking", boardNo);
	}

	@Override
	   public List<DonationBoard> mySelectList(HashMap<String, Object> hashMap) {
	      PageInfo pi = (PageInfo)(hashMap.get("pi"));
	      int offset = (pi.getCurrentPage()-1) * pi.getBoardLimit();
	      RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
	      return sqlSession.selectList("donationBoardMapper.selectMyDonation", hashMap, rowBounds);
	   }

	@Override
	public int insertDonationReply(DonationReply donationReply) {
		return sqlSession.insert("donationBoardMapper.insertDonationReply", donationReply);
	}

	@Override
	public void updateBoardReplyCound(int boardNo) {
		sqlSession.update("donationBoardMapper.addBoardReplyCount", boardNo);
	}

	@Override
	public List<DonationReply> seelectAllReply(int boardNo) {
		return sqlSession.selectList("donationBoardMapper.selectAllReply", boardNo);
	}
}
