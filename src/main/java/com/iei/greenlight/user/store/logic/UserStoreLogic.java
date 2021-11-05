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

	
}
