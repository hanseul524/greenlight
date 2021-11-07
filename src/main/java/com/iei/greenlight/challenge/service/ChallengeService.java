package com.iei.greenlight.challenge.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.iei.greenlight.challenge.domain.ChPageInfo;
import com.iei.greenlight.challenge.domain.Challenge;
import com.iei.greenlight.challenge.domain.Reply;

public interface ChallengeService {
	
	// 글 작성, 수정, 삭제
	public int registerChallenge(Challenge challenge);
	public int modifyChallenge(Challenge challenge);
	public int removeChallenge(Challenge challenge);
	
	// 챌린지 리스트, 상세 페이지
	public int getListCount();
	public List<Challenge> printAll(ChPageInfo pi);
	public Challenge printOne(int chNo);
	public int addLike(int chNo, HttpSession session);
	public int removeList(int chNo, HttpSession session);
	
	// 챌린지 게시판 댓글
	public List<Reply> printAll(int chNo);
	public int registerReply(Reply reply);
	public int modifyReply(Reply reply);
	public int removeReply(Reply reply);
}