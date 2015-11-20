package app04a.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import app04a.domain.Phone;

	@Repository
	public interface PhoneRepository extends  CrudRepository<Phone, Long> 
	{
	
  
	}

