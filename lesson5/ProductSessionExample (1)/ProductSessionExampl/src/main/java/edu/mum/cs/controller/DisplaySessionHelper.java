package edu.mum.cs.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

import edu.mum.cs.domain.Product;

@Component
public class DisplaySessionHelper {

	
    public void getSessionAttributes(Map map, HttpSession session) {
   	 getSessionFromController(map);
   	 getSessionFromHttpSession(session);
   	    
    }
    
   	  private void getSessionFromController(Map map) {

       System.out.println(" Attributes from @SessionAttributes:");
       System.out.println();

       Product product = (Product) map.get("Leonardo");
        if (product != null)  {
       	System.out.printf("Leonardo name : %s\n", product.getName());
        }
      else System.out.printf("No @SessionAttribute named Leonardo \n" );

   	 String splinter = (String) map.get("Splinter");
        if (product != null)  {
        	System.out.printf("Splinter name : %s\n", splinter);
         }
       else System.out.printf("No @SessionAttribute named Splinter \n" );

   	 String donatello = (String) map.get("Donatello");
        if (product != null)  {
        	System.out.printf("Donatello name : %s\n", donatello);
         }
       else System.out.printf("No @SessionAttribute named Donatello \n" );
        System.out.println();

   }

       private void getSessionFromHttpSession(HttpSession session) {
            // Regular attributes
            System.out.println(" Attributes from HttpSession:");
            System.out.println();
            System.out.printf("Donatello : %s\n", session.getAttribute("Donatello"));
            System.out.printf("Splinter : %s\n", session.getAttribute("Splinter"));
            Product leo = (Product)session.getAttribute("Leonardo");
            if (leo != null) System.out.printf("Leonardo : %s\n", leo.getName());
            else System.out.printf("Leonardo : %s\n", leo);
                  System.out.println();
      
    	    
        }
        


}
