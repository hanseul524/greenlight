package com.iei.greenlight.challenge.domain;

public class ChLike {
	
	private int chNo;
	private String userId;
	private String likeCk;
	
	public ChLike() {}

	public int getChNo() {
		return chNo;
	}

	public void setChNo(int chNo) {
		this.chNo = chNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getLikeCk() {
		return likeCk;
	}

	public void setLikeCk(String likeCk) {
		this.likeCk = likeCk;
	}

	@Override
	public String toString() {
		return "ChLike [글 번호=" + chNo + ", 좋아요 아이디=" + userId + ", 좋아요 체크=" + likeCk + "]";
	}
	
	
}
