package com.eprogrammerz.examples.session.controller;

import com.eprogrammerz.examples.session.service.AdviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Controller
@SessionAttributes("userName")
@RequestMapping("/")
public class AdviceController {

    @Autowired
    AdviceService adviceService;

    @RequestMapping(value = {"/", "/advice"}, method = RequestMethod.GET)
    public String adviceForm() {

        return "advice";
    }

    @RequestMapping(value = "/advice", method = RequestMethod.POST)
    public String adviceList(String roast, Model model) throws Exception {

        List<String> roastList = adviceService.getListByType(roast);

        model.addAttribute("roastList", roastList);

        return "display";

    }


}
