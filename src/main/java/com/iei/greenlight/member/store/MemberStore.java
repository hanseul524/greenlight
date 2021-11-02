package com.iei.greenlight.member.store;

import java.util.List;

import com.iei.greenlight.member.domain.Member;

public interface MemberStore {
	
	public List<Member> selectAllList();

}
