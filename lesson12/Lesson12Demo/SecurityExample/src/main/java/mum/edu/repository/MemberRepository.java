package mum.edu.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mum.edu.domain.Member;

	@Repository
	public interface MemberRepository extends  CrudRepository<Member, String> 
	{
		public Member findByMemberNumber(int memberNumber);
 	}

