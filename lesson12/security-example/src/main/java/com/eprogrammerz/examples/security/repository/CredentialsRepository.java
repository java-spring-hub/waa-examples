package com.eprogrammerz.examples.security.repository;


import com.eprogrammerz.examples.security.domain.Credentials;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CredentialsRepository extends CrudRepository<Credentials, String> {
}

