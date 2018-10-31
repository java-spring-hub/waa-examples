package com.eprogrammerz.examples.security.service;

import com.eprogrammerz.examples.security.domain.Member;

import java.util.List;

public interface MemberService {

    public void save(Member member);

    public List<Member> findAll();

    public Member findByMemberNumber(int memberId);

    public void saveFull(Member member);
}
