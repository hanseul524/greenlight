package com.iei.greenlight.challenge.service.logic;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iei.greenlight.challenge.domain.CFile;
import com.iei.greenlight.challenge.domain.Category;
import com.iei.greenlight.challenge.domain.ChLike;
import com.iei.greenlight.challenge.domain.PageInfo;
import com.iei.greenlight.challenge.domain.Challenge;
import com.iei.greenlight.challenge.domain.Reply;
import com.iei.greenlight.challenge.service.ChallengeService;
import com.iei.greenlight.challenge.store.ChallengeStore;

@Service
public class ChallengeServiceImpl implements ChallengeService{
	
	@Autowired
	private ChallengeStore store;
	
	@Override
	public int registerChallenge(Challenge challenge) {
		int result = store.insertChallenge(challenge);
		return result;
	}
	
	@Override
	public int registerChImage(List<CFile> cList) {
		int result = store.insertChImage(cList);
		return result;
	}

	@Override
	public int modifyChallenge(Challenge challenge) {
		int result = store.updateChallenge(challenge);
		return result;
	}

	@Override
	public int removeChallenge(int chNo) {
		int result = store.deleteChallenge(chNo);
		return result;
	}

	@Override
	public int getListCount() {
		int totalCount = store.selectListCount();
		return totalCount;
	}

	@Override
	public List<Challenge> printAll(PageInfo pi) {
		List<Challenge> cList = store.selectAll(pi);
		return cList;
	}

	@Override
	public Challenge printOne(int chNo) {
		Challenge challenge = store.selectOne(chNo);
		return challenge;
	}
	@Override
	public List<CFile> printOneImg(int chNo) {
		List<CFile> cList = store.selectOneImg(chNo);
		System.out.println(cList.toString() + "1111111111111");
		return cList;
	}
	
	@Override
	public List<CFile> printImgDel(int chNo) {
		List<CFile> cList = store.selectImgDel(chNo);
		return cList;
	}
	
//	@Override
//	public int likeCount(int likeCount) {
//		int result = store.selectLikeCount(likeCount);
//		return result;
//	}

	@Override
	public ChLike LikeCk(HashMap<String, Object> hashMap) {
		ChLike chlike = store.selectLike(hashMap);
		return chlike;
	}
	
	@Override
	public int addLike(HashMap<String, Object> hashMap) {
		int result = store.insertLike(hashMap);
		return result;
	}
	
	@Override
	public int updateLike(ChLike chlike) {
		int result = store.updateLike(chlike);
		return result;
	}

	@Override
	public int removeLike(ChLike chlike) {
		int result = store.deleteLike(chlike);
		return result;
	}

	@Override
	public List<Reply> printAll(int chNo) {
		return store.selectAll(chNo);
	}

	@Override
	public int registerReply(Reply reply) {
		int result = store.insertReply(reply);
		return result;
	}

	@Override
	public int modifyReply(Reply reply) {
		int result = store.updateReply(reply);
		return result;
	}

	@Override
	public int removeReply(Reply reply) {
		int result = store.deleteReply(reply);
		return result;
	}

	@Override
	public List<Challenge> printAllCh(PageInfo api) {
		List<Challenge> cList = store.selectAll(api);
		return cList;
	}

	@Override
	public int registerCategory(Category category) {
		int result = store.insertCategory(category);
		return result;
	}
	
	@Override
	public int confirmChallenge(HashMap<String, Object> hashmap) {
		return store.updateChallengeCf(hashmap);
	}
	
	@Override
	public int modifyChPoint(HashMap<String, Object> hashmap) {
		return store.updatePoint(hashmap);
	}

	//마이페이지
	@Override
	public int getMyListCount(String userId) {
	    return store.selectMyListCount(userId);
	}

	@Override
	public List<Challenge> printChallList(HashMap<String, Object> hashMap) {
	    return store.selectMyChall(hashMap);
	 }



}
