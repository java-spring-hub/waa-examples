package mum.edu.service;

import java.util.List;

import mum.edu.domain.Member;
 
public interface MemberService {

	public void save(Member member);
	public List<Member> findAll();
	public Member findByMemberNumber(int memberId);
  	public void saveFull( Member member);  		
}
