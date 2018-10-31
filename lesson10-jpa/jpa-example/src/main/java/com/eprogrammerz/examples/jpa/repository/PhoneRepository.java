package com.eprogrammerz.examples.jpa.repository;


import com.eprogrammerz.examples.jpa.domain.Phone;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneRepository extends CrudRepository<Phone, Long> {


}

