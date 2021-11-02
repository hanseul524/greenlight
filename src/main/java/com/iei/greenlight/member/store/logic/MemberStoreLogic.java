package com.iei.greenlight.member.store.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iei.greenlight.member.domain.Member;
import com.iei.greenlight.member.store.MemberStore;

@Repository
public class MemberStoreLogic implements MemberStore{
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<Member> selectAllList() {
		
		List<Member> mList = sqlSession.selectList("memberMapper.selectAllList");
		
		return mList;
	}

}
