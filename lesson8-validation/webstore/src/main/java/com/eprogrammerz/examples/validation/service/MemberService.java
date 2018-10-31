package com.eprogrammerz.examples.validation.service;

import java.util.List;

import com.eprogrammerz.examples.validation.domain.Member;
 
public interface MemberService {

	public void save(Member member);
	public List<Member> findAll();
	public Member findByMemberNumber(Integer memberId);
}
