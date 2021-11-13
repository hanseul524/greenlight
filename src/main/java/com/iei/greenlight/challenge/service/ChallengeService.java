package com.iei.greenlight.challenge.service;

import java.util.HashMap;
import java.util.List;


import com.iei.greenlight.challenge.domain.CFile;
import com.iei.greenlight.challenge.domain.ChLike;
import com.iei.greenlight.challenge.domain.PageInfo;
import com.iei.greenlight.challenge.domain.Challenge;
import com.iei.greenlight.challenge.domain.Reply;

public interface ChallengeService {
	
	// 글 작성, 수정, 삭제
	public int registerChallenge(Challenge challenge);
	public int registerChImage(List<CFile> cList);
	public int modifyChallenge(Challenge challenge);
	public int removeChallenge(int chNo);
	
	// 챌린지 리스트, 상세 페이지
	public int getListCount();
	public List<Challenge> printAll(PageInfo pi);
	public Challenge printOne(int chNo);
	public List<CFile> printOneImg(int chNo);
	public ChLike LikeCk(HashMap<String, Object> hashMap);
	public int addLike(HashMap<String, Object> hashMap);
	public int updateLike(ChLike chlike);
	public int removeLike(ChLike chlike);
	
	// 챌린지 게시판 댓글
	public List<Reply> printAll(int chNo);
	public int registerReply(Reply reply);
	public int modifyReply(Reply reply);
	public int removeReply(Reply reply);
}
