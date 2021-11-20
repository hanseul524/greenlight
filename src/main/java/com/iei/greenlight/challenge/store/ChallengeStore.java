package com.iei.greenlight.challenge.store;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.iei.greenlight.challenge.domain.CFile;
import com.iei.greenlight.challenge.domain.Category;
import com.iei.greenlight.challenge.domain.ChLike;
import com.iei.greenlight.challenge.domain.PageInfo;
import com.iei.greenlight.challenge.domain.Challenge;
import com.iei.greenlight.challenge.domain.Reply;

public interface ChallengeStore {
	
	// 글 작성, 수정, 삭제
	public int insertChallenge(Challenge challenge);
	public int selectCategory();
	public int insertChImage(List<CFile> cList);
	public int updateChallenge(Challenge challenge);
	public int deleteChallenge(int chNo);
	
	// 챌린지 리스트, 상세 페이지
	public int selectListCount(HashMap<String, Object> hashmap);
	public List<Challenge> selectAll(HashMap<String, Object> hashmap);
	public int selectCategoryTitle(int categoryNo);
	public Challenge selectOne(int chNo);
	public List<CFile> selectOneImg(int chNo);
	public List<CFile> selectImgDel(int chNo);
	public ChLike selectLike(HashMap<String, Object> hashMap);
	public int insertLike(HashMap<String, Object> hashMap);
	public int updateLike(ChLike chlike);
	public int deleteLike(ChLike chlike);
	public int updateLikeCount(Challenge challenge);
	public int deleteLikeCount(Challenge challenge);
	
	// 챌린지 게시판 댓글
	public List<Reply> selectAll(int chNo);
	public int insertReply(Reply reply);
	public int updateReply(Reply reply);
	public int deleteReply(Reply reply);
	
	// 관리자 챌린지 페이지
	public int selectAdminListCount();
	public List<Challenge> printAllCh(PageInfo api);
	public int insertCategory(Category category);
	public int updateChallengeCf(HashMap<String, Object> hashmap);
	public int updatePoint(HashMap<String, Object> hashmap);
	
	//마이페이지
	public int selectMyListCount(String userId);
	public List<Challenge> selectMyChall(HashMap<String, Object> hashMap);
}
