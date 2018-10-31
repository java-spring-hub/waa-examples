<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cookies</title>
</head>
<body>
     <h2 style="text-align: center;">${appName }</h2>
         <p>Permanent Cookie: ${permanentCookie}</p>
  
         <p>Temporary Cookie: ${temporaryCookie}</p>
  

  <form action="home" method="get">
           <input id="submit" type="submit"  
                value="Go Home">
</form>

 </body>
</html>