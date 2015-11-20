package mum;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ControllingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/*
	 *  Just doGet - No Post - so keeps submitting to doGet
	 *  
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			// text input from index.jsp.form
			System.out.println("TEXT: " + request.getParameter("text"));

	        // Print out Select List choice from form [ index.jsp]
	        System.out.println("PHONE: " + request.getParameter("phone"));

			// Set HIDE/SHOW value....for next round...
			String hidden = request.getParameter("hiddenfield");
			if(hidden.equals("Show")) request.setAttribute("hidden", "Show");
			else request.setAttribute("hidden", "Hide");
			
	        // Set up Select list for next round...
			Map< String, String > phonesMap = new HashMap<String, String>();
			phonesMap.put("samsung", "SAMSUNG");
			phonesMap.put("nokia", "NOKIA");
			phonesMap.put("iphone", "IPHONE");
	        phonesMap.put("bberry", "BLACKBERRY");
	        phonesMap.put("htc", "HTC");

	        request.setAttribute("phonesMap", phonesMap);

		
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		doGet(request, response);
	}

}
