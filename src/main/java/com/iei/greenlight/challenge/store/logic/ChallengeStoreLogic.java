package com.iei.greenlight.challenge.store.logic;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iei.greenlight.challenge.domain.CFile;
import com.iei.greenlight.challenge.domain.Category;
import com.iei.greenlight.challenge.domain.ChLike;
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
	public int selectCategory() {
		int cNo = session.selectOne("challengeMapper.selectCategory");
		return cNo;
	}

	@Override
	public int updateChallenge(Challenge challenge) {
		int result = session.update("challengeMapper.updateChallenge", challenge);
		return result;
	}

	@Override
	public int deleteModifyImg(int chNo) {
		return session.delete("challengeMapper.deleteChallengeImg", chNo);
	}

	@Override
	public int deleteChallenge(int chNo) {
		return session.delete("challengeMapper.deleteChallenge", chNo);
	}

	@Override
	public int selectListCount(HashMap<String, Object> hashmap) {
		int count = session.selectOne("challengeMapper.selectListCount", hashmap);
		return count;
	}

	@Override
	public List<Challenge> selectAll(HashMap<String, Object> hashmap) {
		PageInfo pi = (PageInfo)hashmap.get("pi");
		int offset = (pi.getCurrentPage()-1) * pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		List<Challenge> cList = session.selectList("challengeMapper.selectAllList", hashmap, rowBounds);
		return cList;
	}

	@Override
	public int selectSearchListCount(HashMap<String, Object> hashmap) {
		return session.selectOne("challengeMapper.selectSearchListCount", hashmap);
	}

	@Override
	public List<Challenge> selectSearchList(HashMap<String, Object> hashmap) {
		PageInfo pi = (PageInfo)hashmap.get("pi");
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		return session.selectList("challengeMapper.selectSearchList", hashmap, rowBounds);
	}

	
	@Override
	public int selectAdminListCount() {
		return session.selectOne("challengeMapper.selectAdminListCount");
	}

	@Override
	public Challenge selectOne(int chNo) {
		Challenge challenge = session.selectOne("challengeMapper.selectOne", chNo);
		if(challenge != null) {
			session.selectOne("challengeMapper.selectLikeCount", chNo);
		}
		return challenge;
	}

	@Override
	public List<CFile> selectOneImg(int chNo) {
		List<CFile> cList = session.selectList("challengeMapper.selectOneImg", chNo);
		return cList;
	}
	
	@Override
	public List<CFile> selectImgDel(int chNo) {
		List<CFile> cList = session.selectList("challengeMapper.selectOneImgDel", chNo);
		return cList;
	}

	@Override
	public ChLike selectLike(HashMap<String, Object> hashMap) {
		ChLike chlike = session.selectOne("challengeMapper.selectLike", hashMap);
		return chlike;
	}
	
	@Override
	public int insertLike(HashMap<String, Object> hashMap) {
		int result = session.insert("challengeMapper.insertLike", hashMap);
		return result;
	}
		
	@Override
	public int updateLike(ChLike chlike) {
		int result = session.update("challengeMapper.updateLike",chlike);
		return result;
	}

	@Override
	public int deleteLike(ChLike chlike) {
		int result = session.update("challengeMapper.deleteLike", chlike);
		return result;
	}
	
	@Override
	public int updateLikeCount(Challenge challenge) {
		int likeCount = session.update("challengeMapper.updateLikeCount", challenge);
		return likeCount;
	}

	@Override
	public int deleteLikeCount(Challenge challenge) {
		int likeCount = session.update("challengeMapper.deleteLikeCount", challenge);
		return likeCount;
	}

	@Override
	public List<Reply> selectAll(int chNo) {
		List<Reply> rList = session.selectList("challengeMapper.selectAllReply", chNo);
		return rList;
	}

	@Override
	public int insertReply(Reply reply) {
		int result = session.insert("challengeMapper.insertReply", reply);
		if(result > 0) {
			session.update("challengeMapper.updateReplyCount", reply);
		}
		return result;
	}

	@Override
	public int updateReply(Reply reply) {
		int result = session.update("challengeMapper.updateReply", reply);
		return result;
	}

	@Override
	public int deleteReply(Reply reply) {
		int result = session.delete("challengeMapper.deleteReply", reply);
		return result;
	}

	@Override
	public List<Challenge> printAllCh(PageInfo api) {
		int offset = (api.getCurrentPage()-1) * api.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, api.getBoardLimit());
		List<Challenge> cList = session.selectList("challengeMapper.selectAdminAllList", api, rowBounds);
		return cList;
	}

	@Override
	public int insertCategory(Category category) {
		int result = session.insert("challengeMapper.insertCategory", category);
		return result;
	}
	
	@Override
	public Category selectCategoryTitle(int categoryNo) {
		return session.selectOne("challengeMapper.selectCategoryTitle", categoryNo);
	}
	
	@Override
	public int updateChallengeCf(HashMap<String, Object> hashmap) {
		int result = session.update("challengeMapper.updateConfirm", hashmap);
		if(result > 0) {
			session.insert("pointMapper.updateChPoint", hashmap);
		}
		return result;
	}
	
	@Override
	public int updatePoint(HashMap<String, Object> hashmap) {
		int result = session.update("pointMapper.updateUserChPoint", hashmap);
		return result;
	}
	
	// 마이페이지
	@Override
	public int selectMyListCount(String userId) {
	   return session.selectOne("challengeMapper.selectCount", userId);
	}

	@Override
	public List<Challenge> selectMyChall(HashMap<String, Object> hashMap) {
	   PageInfo pi = (PageInfo)(hashMap.get("pi"));
	   int offset = (pi.getCurrentPage()-1) * pi.getBoardLimit();
	   RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
	   return session.selectList("challengeMapper.selectMyChall", hashMap, rowBounds);
	 }

	@Override
	public List<CFile> selectDeleteImg(int chNo) {
		return session.selectList("challengeMapper.selectDelteImg", chNo);
	}


}
