package mum.edu.cs;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Calculator
 */
 
public class Order extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Order() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/order.jsp");
		requestDispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  
		request.setAttribute("name", request.getParameter("name"));	
		request.setAttribute("address", request.getParameter("address"));
		request.setAttribute("country", request.getParameter("country"));
		request.setAttribute("deliveryMethod", request.getParameter("deliveryMethod"));
		
		String catalogRequest = request.getParameter("catalogRequest");
		if (catalogRequest == null)
			catalogRequest ="No";
		else catalogRequest = "Yes";
		request.setAttribute("catalogRequest", catalogRequest);
 		
		
        String[] instructions = request.getParameterValues("instruction");
        request.setAttribute("instructions", instructions);
        
 	
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/orderDetails.jsp");
		requestDispatcher.forward(request, response);
		
	}
 

}
