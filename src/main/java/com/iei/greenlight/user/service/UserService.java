package com.iei.greenlight.user.service;

import com.iei.greenlight.user.domain.User;

public interface UserService {

	public User loginUser(User user);

	public void certifiedPhoneNumber(String phoneNumber, String numStr);

	public int registerUser(User user);

	public int checkIdDup(String userId);
}
