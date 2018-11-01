package com.eprogrammerz.examples.session.service;

import com.eprogrammerz.examples.session.domain.User;

import java.util.List;


public interface UserService {

    public List<User> getAll();

    public User findByName(String name);


}
 
