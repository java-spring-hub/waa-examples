
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Introduction to JSP demo – Postback page </title>
    </head>
    <body>
        <p>This is the postback message</p>
  
  <!-- Scriptlet -->  
  	<% int day = Integer.parseInt(request.getParameter("dayOfWeek"));  
  	if (day <= 1 | day >= 7) { %>
      <p> Today is a weekend day</p>
 
	<% } else { %>
      <p> Today is not a weekend day</p>
	<% } %>
 
  
  <%-- EL examples... 
  	dayName  is attribute set in Servlet
  	dayNumber  is attribute set in Servlet
  	dayOfWeek is request parameter
   --%>
      <p>
     	It's  ${dayName}!!
      </p>
     Request parameter Number = ${param["dayOfWeek"]}<br>
 
     Number Greater than 7 = ${dayNumber gt 7}<br>
  
  
        
        <!--  Class level declaration initialized ONLY on load -->
       <%! int count = 0; %>
      
      <%-- This is a jsp scriptlet that increments the count --%>
       The count is now:  
      <%= ++count %>
 
      <!-- This is a scriptlet that increases the count by a power of 10 -->
      <% count = count * 10; %>
      The count is now:  
      <%= count %>
 
         <p>
         <a href='index.jsp'>Go to Start</a>
        </p>
 
        
    </body>
</html>