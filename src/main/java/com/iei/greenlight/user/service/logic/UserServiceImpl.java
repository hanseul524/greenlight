package com.iei.greenlight.user.service.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iei.greenlight.user.domain.User;
import com.iei.greenlight.user.service.UserService;
import com.iei.greenlight.user.store.UserStore;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserStore store;
	
	@Override
	public User loginUser(User user) {
		User userOne = store.loginUser(user);
		return userOne;
	}
	

}
