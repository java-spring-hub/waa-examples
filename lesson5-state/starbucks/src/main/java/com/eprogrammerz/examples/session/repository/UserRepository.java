package com.eprogrammerz.examples.session.repository;

import com.eprogrammerz.examples.session.domain.User;

import java.util.List;


public interface UserRepository {

    public List<User> getAll();

    public User findByName(String name);


}
 
