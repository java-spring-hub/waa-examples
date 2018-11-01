package com.eprogrammerz.examples.webstore.domain.repository;


import com.eprogrammerz.examples.webstore.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository {
    public Member findByMemberNumber(Integer memberNumber);

    public List<Member> findAll();

    public void save(Member member);
}

