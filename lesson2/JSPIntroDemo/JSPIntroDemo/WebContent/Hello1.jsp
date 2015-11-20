 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <title>Introduction to JSP demo – Hello page</title>
    </head>
    <body>
    <%  
		String name = request.getParameter("yourName");
		StringBuilder myName = new StringBuilder(name);
		Character c = Character.toUpperCase(name.charAt(0));
		myName.setCharAt(0, c);   

    %>      
    Hello  <%= myName  %>  <br>
        <form method='post' action='JSPIntroDemo'>
Day of Week[1-7]: <input type = "text" name = "dayOfWeek"/><br/>
            <input type='submit' name='btnSubmit' value='Click me'/>
        </form>
    </body>
</html>