package com.eprogrammerz.examples.security.controller;

import com.eprogrammerz.examples.security.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {


    @Autowired
    private MemberService customerService;

    @RequestMapping({"/", "/welcome"})
    public String welcome(Model model) {

        model.addAttribute("greeting", "Welcome to our community, Kimosabe!!");
        model.addAttribute("tagline", "The one and only place to live, work and play!!");

        return "welcome";
    }

}
