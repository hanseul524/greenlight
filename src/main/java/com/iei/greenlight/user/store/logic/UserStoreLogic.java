package com.iei.greenlight.user.store.logic;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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

	

	
}
