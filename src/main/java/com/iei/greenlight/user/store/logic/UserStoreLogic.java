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
	
	@Override
	public User loginUser(User user) {
		User userOne = sqlSession.selectOne("userMapper.loginUser", user);
		return userOne;
	}
	
	@Override
	public int checkIdDup(String userId) {
		int result = sqlSession.selectOne("userMapper.checkIdDup", userId);
		return result;
	}

	@Override
	public int insertUser(User user) {
		int result = sqlSession.insert("userMapper.insertUser", user);
		return result;
	}

	

	
}
