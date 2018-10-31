package com.eprogrammerz.examples.session.controller;

import com.eprogrammerz.examples.session.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    @Autowired
    ServletContext servletContext;

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String inputProduct(Product product, Model model, HttpSession session) {

        System.out.println("HOME");
        return "Home";
    }


}
