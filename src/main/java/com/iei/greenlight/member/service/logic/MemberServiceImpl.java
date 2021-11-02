package com.iei.greenlight.member.service.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iei.greenlight.member.domain.Member;
import com.iei.greenlight.member.service.MemberService;
import com.iei.greenlight.member.store.MemberStore;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private MemberStore store;

	@Override
	public List<Member> printAllList() {
		
		List<Member> mList = store.selectAllList();
		
		return mList;
	}

}
