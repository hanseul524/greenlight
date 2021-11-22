package com.iei.greenlight.user.store.logic;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iei.greenlight.event.domain.EventWinner;
import com.iei.greenlight.user.domain.PageInfo;
import com.iei.greenlight.user.domain.User;
import com.iei.greenlight.user.store.UserStore;

@Repository
public class UserStoreLogic implements UserStore{

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	// 로그인
	@Override
	public User loginUser(User user) {
		User userOne = sqlSession.selectOne("userMapper.loginUser", user);
		return userOne;
	}
	
	// 아이디 중복확인
	@Override
	public int checkIdDup(String userId) {
		int result = sqlSession.selectOne("userMapper.checkIdDup", userId);
		return result;
	}

	// 회원 등록
	@Override
	public int insertUser(User user) {
		int result = sqlSession.insert("userMapper.insertUser", user);
		return result;
	}

	// 아이디 찾기 체크
	@Override
	public int checkUserId(User userOne) {
		int result = sqlSession.selectOne("userMapper.findUserId", userOne);
		return result;
	}

	@Override
	public String showUserId(User userOne) {
		String userId = sqlSession.selectOne("userMapper.selectUserIdByNameAndEmail", userOne);
		return userId;
	}

	@Override
	public int checkUserPwd(User userOne) {
		int result = sqlSession.selectOne("userMapper.checkUserpwd", userOne);
		return result;
	}

	@Override
	public int updateUserPwd(User userOne) {
		int result = sqlSession.update("userMapper.updateUserPwd", userOne);
		return result;
	}

	@Override
	public int checkSocialId(User userOne) {
		int result = sqlSession.selectOne("userMapper.checkSocialId", userOne);
		return result;
	}

	@Override
	public String socialIdLogin(String socialId) {
		String userId = sqlSession.selectOne("userMapper.socialIdLogin", socialId);
		return userId;
	}

	@Override
	public int socialInsertUser(User user) {
		int result = sqlSession.insert("userMapper.socialInsertUser", user);
		return result;
	}

	@Override
	public User selectUser(String userId) {
		User user = sqlSession.selectOne("userMapper.selectUserOne", userId);
		return user;
	}

	@Override
	public int updateUser(User user) {
		int result = sqlSession.update("userMapper.updateUserOne", user);
		return result;
	}
	
	@Override
	public int updateUserPoint(HashMap<String, Object> pointMap) {
		int result = sqlSession.update("userMapper.updateUserPoint", pointMap);
		return result;
	}
	
	@Override
	public int updateUserMinusPoint(HashMap<String, Object> pointMap) {
		int result = sqlSession.update("userMapper.updateUserMinusPoint", pointMap);
		return result;
	}

	@Override
	public int updateUserChargePoint(HashMap<String, Object> chargePointMap) {
		int result = sqlSession.update("userMapper.updateUserChargePoint", chargePointMap);
		return result;
	}
	
	@Override
	public int updateSellerPoint(HashMap<String, Object> pointMap) {
		int result = sqlSession.update("userMapper.updateSellerPoint", pointMap);
		return result;
	}
	
	@Override
	public int updateEventAnswerPoint(String userId) {
		return sqlSession.update("userMapper.updateEventAnswerPoint", userId);
	}
	
	@Override
	public int updateEventWinnerPoing(List<EventWinner> wList) {
		return sqlSession.update("userMapper.updateEventWinnerPoint", wList);
	}
	
	@Override
	public int deleteUser(String userId) {
		int result = sqlSession.delete("userMapper.deleteUserOne", userId);
		return result;
	}

	@Override
	public int updateChargePoint(User userOne) {
		return sqlSession.update("userMapper.updateChargePoint", userOne);
	}

	@Override
	public int updateCancelChargePoint(User user) {
		return sqlSession.update("userMapper.updateCancelChargePoint", user);
	}

	// 관리자 페이지 회원 관리
	@Override
	public List<User> selectUserList(PageInfo upi) {
		int offset = (upi.getCurrentPage() - 1) * upi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, upi.getBoardLimit());
		List<User> uList = sqlSession.selectList("userMapper.selectAllList", upi, rowBounds);
		return uList;
	}

	@Override
	public int selectListCount() {
		int totalCount = sqlSession.selectOne("userMapper.selectListCount");
		return totalCount;
	}

	@Override
	public int deleteUser(List<String> uList) {
		int result = sqlSession.delete("userMapper.deleteUserList", uList);
		return result;
	}

	@Override
	public int selectSearchListCount(String userId) {
		return sqlSession.selectOne("userMapper.selectSearchListCount", userId);
	}

	@Override
	public List<User> selectSearchList(HashMap<String, Object> hashmap) {
		PageInfo upi = (PageInfo)hashmap.get("upi");
		int offset = (upi.getCurrentPage() -1) * upi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, upi.getBoardLimit());
		return sqlSession.selectList("userMapper.selectSearchList", hashmap, rowBounds);
	}

}
