package mum.edu.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class OrderContextListener implements ServletContextListener{

 
		  public void contextInitialized(ServletContextEvent event){
 
			  ServletContext servletContext = event.getServletContext();

			String applicationName = servletContext.getInitParameter("applicationName");
		    servletContext.setAttribute("applicationName", applicationName);

 		  }

		  public void contextDestroyed(ServletContextEvent event){}

 



}
