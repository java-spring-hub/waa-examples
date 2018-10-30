package com.eprogrammerz.examples.security.service.impl;

import com.eprogrammerz.examples.security.service.MemberService;
import com.eprogrammerz.examples.security.domain.Member;
import com.eprogrammerz.examples.security.repository.MemberRepository;
import com.eprogrammerz.examples.security.service.CredentialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MemberServiceImpl implements MemberService {

    @Autowired
    CredentialsService credentialsService;
    @Autowired
    private MemberRepository memberRepository;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void saveFull(Member member) {
        credentialsService.save(member.getCredentials());
        memberRepository.save(member);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void save(Member member) {
        memberRepository.save(member);
    }


    public List<Member> findAll() {
        return (List<Member>) memberRepository.findAll();
    }

    public Member findByMemberNumber(int memberId) {
        return memberRepository.findByMemberNumber(memberId);
    }


}
