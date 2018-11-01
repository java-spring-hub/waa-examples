package com.eprogrammerz.examples.springmvc.service.impl;

import com.eprogrammerz.examples.springmvc.domain.User;
import com.eprogrammerz.examples.springmvc.service.FormValidator;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FormValidatorImpl implements FormValidator {
    public List<String> validateForm(Object object) {
        List<String> errors = new ArrayList<String>();

        User user = (User) object;
        if (user.getName().isEmpty() || user.getPassword().isEmpty()) {
            errors.add("Username and password field must be filled.");
        }
        return errors;
    }
}
