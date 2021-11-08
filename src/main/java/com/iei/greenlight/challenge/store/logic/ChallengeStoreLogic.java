package com.iei.greenlight.challenge.store.logic;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iei.greenlight.challenge.domain.CFile;
import com.iei.greenlight.challenge.domain.PageInfo;
import com.iei.greenlight.challenge.domain.Challenge;
import com.iei.greenlight.challenge.domain.Reply;
import com.iei.greenlight.challenge.store.ChallengeStore;

@Repository
public class ChallengeStoreLogic implements ChallengeStore {

	@Autowired
	private SqlSession session;
	
	@Override
	public int insertChallenge(Challenge challenge) {
		int result = session.insert("challengeMapper.insertChallenge", challenge);
		return result;
	}
	
	@Override
	public int insertChImage(List<CFile> cList) {
		int result = session.insert("challengeMapper.insertImage", cList);
		return result;
	}

	@Override
	public int updateChallenge(Challenge challenge) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteChallenge(Challenge challenge) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int selectListCount() {
		int count = session.selectOne("challengeMapper.selectListCount");
		return count;
	}

	@Override
	public List<Challenge> selectAll(PageInfo pi) {
		int offset = (pi.getCurrentPage()-1) * pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		List<Challenge> cList = session.selectList("challengeMapper.selectAllList", pi, rowBounds);
		return cList;
	}

	@Override
	public Challenge selectOne(int chNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateLike(int chNo, HttpSession session) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteLike(int chNo, HttpSession session) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Reply> selectAll(int chNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertReply(Reply reply) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateReply(Reply reply) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteReply(Reply reply) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int selectCategory(Challenge challenge) {
		// TODO Auto-generated method stub
		return 0;
	}

}
