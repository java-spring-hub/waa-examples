package com.eprogrammerz.examples.webstore.service.impl;

import com.eprogrammerz.examples.webstore.domain.Member;
import com.eprogrammerz.examples.webstore.domain.repository.MemberRepository;
import com.eprogrammerz.examples.webstore.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public void save(Member member) {
        memberRepository.save(member);
    }

    public List<Member> findAll() {
        return (List<Member>) memberRepository.findAll();
    }

    public Member findByMemberNumber(Integer memberId) {
        return memberRepository.findByMemberNumber(memberId);
    }


}
