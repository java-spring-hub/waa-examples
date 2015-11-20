package mum.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class XSSController {

    @RequestMapping(value = "/XSS", method = RequestMethod.GET)
   public String XSS() {

        return "XSS";
   }

    @RequestMapping(value = "/addXSS", method = RequestMethod.GET)
    public String addXSS(@RequestParam("userName") String name, Model model) {

     	model.addAttribute("userName",name);
         return "addXSS";
    }

  
    @RequestMapping(value = "/TaddXSS/{xss}", method = RequestMethod.GET)
    public String adXSS(@PathVariable("xss") String name, Model model) {

     	model.addAttribute("userName",name);
         return "addXSS";
    }

  
}