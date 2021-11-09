package com.iei.greenlight.user.service;

import com.iei.greenlight.user.domain.User;

public interface UserService {

	public User loginUser(User user);

	public void certifiedPhoneNumber(String phoneNumber, String numStr);

	public int registerUser(User user);

	public int checkIdDup(String userId);

	public int checkUserId(User userOne);
	
	public void sendMail(String subject, String content, String sender, String receiver);

	public String showUserId(User userOne);

	public int checkUserPwd(User userOne);

	public int modifyUserPwd(User userOne);

	public int checkSocialId(User userOne);

	public String socialIdLogin(String socialId);

	public int socialRegisterUser(User user);
}
