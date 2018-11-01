package com.eprogrammerz.examples.springmvc.controller;

import com.eprogrammerz.examples.springmvc.domain.User;
import com.eprogrammerz.examples.springmvc.service.FormValidator;
import com.eprogrammerz.examples.springmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping({"/", "login"})
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    FormValidator formValidator;

    @RequestMapping(name = "/")
    public String loginPage() {
        return "index";
    }

    @RequestMapping(name = "login", method = RequestMethod.POST)
    public String login(User user, Model model) {
        List<String> errors = formValidator.validateForm(user);
        if (errors.isEmpty()) {
            errors = userService.verifyUser(user);
            if (errors.isEmpty()) {
                return "loginSuccess";
            }

        }
        model.addAttribute("errors", errors);
        return "index";
    }

}
