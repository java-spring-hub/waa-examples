package com.eprogrammerz.examples.springmvc.service;

import com.eprogrammerz.examples.springmvc.domain.User;

import java.util.List;

public interface UserService {
    List<String> verifyUser(User user);

}
