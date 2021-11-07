package com.iei.greenlight.challenge.store.logic;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.iei.greenlight.challenge.domain.ChPageInfo;
import com.iei.greenlight.challenge.domain.Challenge;
import com.iei.greenlight.challenge.domain.Reply;
import com.iei.greenlight.challenge.store.ChallengeStore;

public class ChallengeStoreLogic implements ChallengeStore {

	@Autowired
	private SqlSession session;
	
	@Override
	public int insertChallenge(Challenge challenge) {
		int result = session.insert("challengeMapper.insertCh", challenge);
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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Challenge> selectAll(ChPageInfo pi) {
		// TODO Auto-generated method stub
		return null;
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
