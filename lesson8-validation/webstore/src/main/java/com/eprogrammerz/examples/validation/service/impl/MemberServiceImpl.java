package com.eprogrammerz.examples.validation.service.impl;

import java.util.List;

import com.eprogrammerz.examples.validation.domain.repository.MemberRepository;
import com.eprogrammerz.examples.validation.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eprogrammerz.examples.validation.domain.Member;

@Service
public class MemberServiceImpl implements MemberService {
	
 	@Autowired
	private MemberRepository memberRepository;

  	public void save( Member member) {
		memberRepository.save(member);
	}
	public List<Member> findAll() {
		return (List< Member>)memberRepository.findAll();
	}

	public Member findByMemberNumber(Integer memberId) {
		return memberRepository.findByMemberNumber(memberId);
	}
 

}
