package com.eprogrammerz.examples.security.service;

import com.eprogrammerz.examples.security.domain.Credentials;

import java.util.List;

public interface CredentialsService {

    public void save(Credentials credentials);

    public List<Credentials> findAll();
}
