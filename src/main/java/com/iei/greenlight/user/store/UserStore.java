package com.iei.greenlight.user.store;

import com.iei.greenlight.user.domain.User;

public interface UserStore {

	public User loginUser(User user);

	public int insertUser(User user);

	public int checkIdDup(String userId);

	public int checkUserId(User userOne);

	public String showUserId(User userOne);

	public int checkUserPwd(User userOne);

	public int updateUserPwd(User userOne);
}
