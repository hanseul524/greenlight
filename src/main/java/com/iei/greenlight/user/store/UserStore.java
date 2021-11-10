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

	public int checkSocialId(User userOne);

	public String socialIdLogin(String socialId);

	public int socialInsertUser(User user);
	
	User selectUser(String userId);
	
	int updateUser(User user);
	
	int deleteUser(String userId);
}
