package com.eprogrammerz.examples.springmvc.service.impl;

import com.eprogrammerz.examples.springmvc.data.DataFacade;
import com.eprogrammerz.examples.springmvc.domain.User;
import com.eprogrammerz.examples.springmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private DataFacade dataFacade;

    @Override
    public List<String> verifyUser(User user) {
        List<String> errors = new ArrayList<>();
        String expectedPassword = dataFacade.findPassword(user.getName());
        if (expectedPassword.isEmpty() || !expectedPassword.equals(user.getPassword())) {
            errors.add("Password and username didn't matched");
        }
        return errors;
    }

	/*@Autowired 
	UserRepository userRepository;
	
	public List<User> getAll() {
		return userRepository.getAll();
	}
	
	public User findByName(String name) {
		return userRepository.findByName(name);
	}*/

}
