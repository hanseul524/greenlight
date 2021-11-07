package com.iei.greenlight.challenge.service.logic;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.iei.greenlight.challenge.domain.ChPageInfo;
import com.iei.greenlight.challenge.domain.Challenge;
import com.iei.greenlight.challenge.domain.Reply;
import com.iei.greenlight.challenge.service.ChallengeService;
import com.iei.greenlight.challenge.store.ChallengeStore;

public class ChallengeServiceImpl implements ChallengeService{
	
	@Autowired
	private ChallengeStore store;
	
	@Override
	public int registerChallenge(Challenge challenge) {
		int result = store.insertChallenge(challenge);
		return result;
	}

	@Override
	public int modifyChallenge(Challenge challenge) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeChallenge(Challenge challenge) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getListCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Challenge> printAll(ChPageInfo pi) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Challenge printOne(int chNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addLike(int chNo, HttpSession session) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeList(int chNo, HttpSession session) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Reply> printAll(int chNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int registerReply(Reply reply) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int modifyReply(Reply reply) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeReply(Reply reply) {
		// TODO Auto-generated method stub
		return 0;
	}

}
