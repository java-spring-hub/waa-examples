package com.eprogrammerz.examples.webstore.domain.repository.impl;

import com.eprogrammerz.examples.webstore.domain.Member;
import com.eprogrammerz.examples.webstore.domain.repository.MemberRepository;
import com.eprogrammerz.examples.webstore.exception.ProductNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryMemberRepository implements MemberRepository {

    private List<Member> listOfMembers = new ArrayList<Member>();


    public List<Member> findAll() {
        return listOfMembers;
    }

    public Member findByMemberNumber(Integer memberNumber) {
        Member memberByNumber = null;

        for (Member member : listOfMembers) {
            if (member != null && member.getMemberNumber() != null && member.getMemberNumber().equals(memberNumber)) {
                memberByNumber = member;
                break;
            }
        }

        if (memberByNumber == null) {
            throw new ProductNotFoundException("No members found with the member number: " + memberNumber);
        }

        return memberByNumber;
    }


    public void save(Member member) {
        listOfMembers.add(member);
    }

}
