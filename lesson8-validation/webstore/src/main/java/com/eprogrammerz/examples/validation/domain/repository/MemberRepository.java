package com.eprogrammerz.examples.validation.domain.repository;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.eprogrammerz.examples.validation.domain.Member;

	@Repository
	public interface MemberRepository   
	{
		public Member findByMemberNumber(Integer memberNumber);
		public List<Member> findAll();
		public void save( Member member);
 	}

