package com.iei.greenlight.user.domain;

import java.sql.Date;

public class User {
	private String userId;
	private String userPwd;
	private String userName;
	private String userEmail;
	private String userAddr;
	private String userPhone;
	private Date regDate;
	private int point;
	private int chargePoint;
	private char admin;
	private String socialId;
	private int count;
	
	public User() {}
	
	public User(String userId, String userPwd, String userName, String userEmail, String userAddr, String userPhone,
			Date regDate, int point, int chargePoint, char admin, String socialId, int count) {
		super();
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userAddr = userAddr;
		this.userPhone = userPhone;
		this.regDate = regDate;
		this.point = point;
		this.chargePoint = chargePoint;
		this.admin = admin;
		this.socialId = socialId;
		this.count = count;
	}

	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserAddr() {
		return userAddr;
	}

	public void setUserAddr(String userAddr) {
		this.userAddr = userAddr;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public int getChargePoint() {
		return chargePoint;
	}

	public void setChargePoint(int chargePoint) {
		this.chargePoint = chargePoint;
	}

	public char getAdmin() {
		return admin;
	}

	public void setAdmin(char admin) {
		this.admin = admin;
	}

	public String getSocialId() {
		return socialId;
	}

	public void setSocialId(String socialId) {
		this.socialId = socialId;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userPwd=" + userPwd + ", userName=" + userName + ", userEmail=" + userEmail
				+ ", userAddr=" + userAddr + ", userPhone=" + userPhone + ", regDate=" + regDate + ", point=" + point
				+ ", chargePoint=" + chargePoint + ", admin=" + admin + ", socialId=" + socialId + ", count=" + count
				+ "]";
	}

}
