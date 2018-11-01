package com.eprogrammerz.examples.session.repository.impl;

import com.eprogrammerz.examples.session.data.Database;
import com.eprogrammerz.examples.session.domain.User;
import com.eprogrammerz.examples.session.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    Database data;

    public List<User> getAll() {
        return (List<User>) data.users.values();
    }


    public User findByName(String name) {
        User user = data.users.get(name);

        return user;
    }


}
 
