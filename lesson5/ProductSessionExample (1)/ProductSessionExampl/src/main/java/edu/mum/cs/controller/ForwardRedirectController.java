package edu.mum.cs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import edu.mum.cs.domain.Product;

@Controller
 public class ForwardRedirectController {

    // Demo redirect PLUS demo  @RequestParam 
    @RequestMapping(value="/redirect" )
    public String redirect (Product product,Model model ) {
        System.out.println("REDIRECT");

    	product.setDescription("Request Attribute Exists!!");
      // This is a request attribute
        // Shouldn't see it on Redirect
        model.addAttribute("requestAttribute",product);
        
        // This will become a URL parameter on Redirect
        model.addAttribute("redirectParamTest","Request Parameter EXISTS!");

        return "redirect:/demoRedirect";
    }   
    
    
    @RequestMapping(value="/demoRedirect" )
    public String getRedirect (@RequestParam("redirectParamTest")String requestParameter, Model model ) {
        System.out.println("GET REDIRECT");
   	 
    	model.addAttribute("redirectParamTest",requestParameter);
  
        // Should NOT see RequestAttribute on session.jsp
        return "ForwardRedirect";
    }   


    // Demo forward  
    @RequestMapping(value="/forward" )
    public String forward (Product product, Model model) {
    	
    	product.setDescription("Request Attribute Exists!!");
        // This is a request attribute
        // Should  see it on Forward
        model.addAttribute("requestAttribute",product);
  
        // This will NOT become a URL parameter on Forward
        // BUT it will still be available...
        model.addAttribute("redirectParamTest","Request Parameter EXISTS!");

        System.out.println("FORWARD");
   
       return "forward:/get_forward";
    }   
    
    @RequestMapping(value="/get_forward" )
    public String getForward (Model model) {
   	
        System.out.println(" GET FORWARD");
        
        // Should see RequestAttribute on JSP
        // Should see redirectParamTest on JSP
              return "ForwardRedirect";
    }   

  
}
