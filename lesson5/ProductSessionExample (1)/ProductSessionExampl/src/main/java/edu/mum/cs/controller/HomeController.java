package edu.mum.cs.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.mum.cs.domain.Product;

@Controller
 public class HomeController {
 
 @Autowired
ServletContext servletContext;
 
 	@RequestMapping(value={"/","/home"}, method = RequestMethod.GET)
 	public String inputProduct(Product product, Model model, HttpSession session) {

        System.out.println("HOME");
         return "Home";
    }

 
}
