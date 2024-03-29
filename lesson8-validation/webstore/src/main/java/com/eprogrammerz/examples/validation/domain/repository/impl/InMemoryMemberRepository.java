package com.eprogrammerz.examples.validation.domain.repository.impl;

import java.util.ArrayList;
import java.util.List;

import com.eprogrammerz.examples.validation.domain.repository.MemberRepository;
import org.springframework.stereotype.Repository;

import com.eprogrammerz.examples.validation.domain.Member;
import com.eprogrammerz.examples.validation.exception.ProductNotFoundException;

@Repository
public class InMemoryMemberRepository implements MemberRepository {
	
	private List<Member> listOfMembers = new ArrayList<Member>();
	
 
	public List<Member> findAll() {
		return listOfMembers;
	}

	public Member findByMemberNumber(Integer memberNumber) {
		Member memberByNumber = null;
		
		for(Member member : listOfMembers) {
			if(member!=null && member.getMemberNumber() != null && member.getMemberNumber().equals(memberNumber)){
				memberByNumber = member;
				break;
			}
		}
		
		if(memberByNumber == null){
			throw new ProductNotFoundException("No members found with the member number: "+ memberNumber);
		}
		
		return memberByNumber;
	}
	
 
	
	public void save(Member member) {
		   listOfMembers.add(member);
	}

}
