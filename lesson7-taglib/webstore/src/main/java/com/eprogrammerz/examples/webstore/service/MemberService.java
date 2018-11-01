package com.eprogrammerz.examples.webstore.service;

import com.eprogrammerz.examples.webstore.domain.Member;

import java.util.List;

public interface MemberService {

    public void save(Member member);

    public List<Member> findAll();

    public Member findByMemberNumber(Integer memberId);
}
