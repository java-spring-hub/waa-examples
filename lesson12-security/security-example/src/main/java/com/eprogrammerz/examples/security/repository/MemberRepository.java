package com.eprogrammerz.examples.security.repository;


import com.eprogrammerz.examples.security.domain.Member;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends CrudRepository<Member, String> {
    public Member findByMemberNumber(int memberNumber);
}

