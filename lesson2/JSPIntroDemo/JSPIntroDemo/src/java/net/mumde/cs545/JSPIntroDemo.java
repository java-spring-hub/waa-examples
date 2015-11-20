/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.mumde.cs545;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 
 */
 
public class JSPIntroDemo extends HttpServlet {


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
    	String name = request.getParameter("yourName");
    	StringBuilder myName = new StringBuilder(name);
    	Character c = Character.toUpperCase(name.charAt(0));
    	myName.setCharAt(0, c);   
    	
    	request.setAttribute("myName", myName);
    	
        RequestDispatcher dispatcher = request.getRequestDispatcher("Hello.jsp");
        dispatcher.forward(request, response);
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	int day = Integer.parseInt(request.getParameter("dayOfWeek"));
    	String dayName;
      	switch(day) {
      	case 1:
      	   dayName = "Sunday";
      	   break;
      	case 2:
      		dayName = "Monday";
      	   break;
      	case 3:
      		dayName = "Tuesday";
      	   break;
      	case 4:
      		dayName = "Wednesday";
      	   break;
      	case 5:
      		dayName = "Thursday";
      	   break;
      	case 6:
      		dayName = "Friday";
      	   break;
      	default:
      		dayName = "Saturday";
      	}
      		
      	request.setAttribute("dayName", dayName);
      	request.setAttribute("dayNumber", day );
      	
        RequestDispatcher dispatcher = request.getRequestDispatcher("PostMessage.jsp");
        dispatcher.forward(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
