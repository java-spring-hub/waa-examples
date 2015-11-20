package com.packt.webstore.service;

import java.util.List;

import com.packt.webstore.domain.Member;
 
public interface MemberService {

	public void save(Member member);
	public List<Member> findAll();
	public Member findByMemberNumber(Integer memberId);
}
