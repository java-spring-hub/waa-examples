package com.eprogrammerz.examples.validation.contoller;

import com.eprogrammerz.examples.validation.domain.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/registration")
public class StudentController {

    @RequestMapping(method = RequestMethod.GET)
    public String showForm(@ModelAttribute("student") Student student, Model model) {

        return "registration";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String processForm(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "registration";
        }

        return "success";
    }

}

	

