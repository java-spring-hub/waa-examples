package com.eprogrammerz.examples.session.service.impl;

import com.eprogrammerz.examples.session.domain.User;
import com.eprogrammerz.examples.session.repository.UserRepository;
import com.eprogrammerz.examples.session.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> getAll() {
        return userRepository.getAll();
    }

    public User findByName(String name) {
        return userRepository.findByName(name);
    }


}
 
