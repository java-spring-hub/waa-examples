package com.eprogrammerz.examples.springmvc.controller;

import com.eprogrammerz.examples.springmvc.service.AdviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class AdviceController {
    @Autowired
    AdviceService adviceService;

    @RequestMapping(value = "/display", method = RequestMethod.GET)
    public String advice() {
        return "display";
    }

    @RequestMapping(name = "advice", method = RequestMethod.GET)
    public String display(String roast, Model model) {
        List<String> advices = adviceService.getAdvice(roast);
        model.addAttribute("advices", advices);
        model.addAttribute("roast", roast);
        return "advice";
    }
}
