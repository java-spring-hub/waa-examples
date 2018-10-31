package com.eprogrammerz.examples.session.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;
import java.util.Map;

/*
 *
 * ..PASSING Session Attributes to Another Controller [ from SessionController]
 */
@Controller
//Donatello was "set" in product as a "regular Attribute
// We are making him into a @SessionAttribute now!!!
@SessionAttributes({"Leonardo", "Donatello"})
public class DelegateSessionController {

    @Autowired
    DisplaySessionHelper displaySession;

    @RequestMapping(value = {"/delegateSession"}, method = RequestMethod.GET)
    public String delegate(Map map, HttpSession session, SessionStatus status) {

        System.out.println("DELEGATE SESSION GET");
        System.out.println();

        // Display Session attribute[s]  
        displaySession.getSessionAttributes(map, session);


        // Should remove Donatello [even though set as a "regular" attribute in Product]
        // as he was declared as a @SessionAttribute HERE
        status.setComplete();


        return "SessionForm";
    }


}
