package com.iei.greenlight.challenge.store;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.iei.greenlight.challenge.domain.CFile;
import com.iei.greenlight.challenge.domain.ChLike;
import com.iei.greenlight.challenge.domain.PageInfo;
import com.iei.greenlight.challenge.domain.Challenge;
import com.iei.greenlight.challenge.domain.Reply;

public interface ChallengeStore {
	
	// 글 작성, 수정, 삭제
	public int insertChallenge(Challenge challenge);
	public int insertChImage(List<CFile> cList);
	public int updateChallenge(Challenge challenge);
	public int deleteChallenge(int chNo);
	
	// 챌린지 리스트, 상세 페이지
	public int selectListCount();
	public List<Challenge> selectAll(PageInfo pi);
	public Challenge selectOne(int chNo);
	public List<CFile> selectOneImg(int chNo);
	public int updateLike(ChLike chlike);
	public int deleteLike(ChLike chlike);
	
	// 챌린지 게시판 댓글
	public List<Reply> selectAll(int chNo);
	public int insertReply(Reply reply);
	public int updateReply(Reply reply);
	public int deleteReply(Reply reply);
	public int selectCategory(Challenge challenge);

}
