package com.packt.webstore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.packt.webstore.domain.Member;
import com.packt.webstore.domain.repository.MemberRepository;
import com.packt.webstore.service.MemberService;

@Service
public class MemberServiceImpl implements  MemberService {
	
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
