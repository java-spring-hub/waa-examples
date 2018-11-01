package com.eprogrammerz.examples.rest.controller;

import com.eprogrammerz.examples.rest.domain.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@Controller
public class EmployeeController {


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String ShowEmployee() {
        return "employee";
    }

    @RequestMapping(value = "/Add", method = RequestMethod.POST)
    public @ResponseBody
    Employee AddEmployee(@Valid @RequestBody Employee employee) {
        return employee;
    }
}
