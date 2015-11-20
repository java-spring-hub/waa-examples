<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JSTL Core Tags Example</title>
</head>
<body>
    <!-- sets variable test so it has value "JSTL and/or EL" -->
    <c:set var="test" value="JSTL -and/or- EL"></c:set>

    <!-- prints to the page the value of the variable 'test' -->
    
    <b>JSTL c:out EXAMPLE -- </b><br>
    <c:out value="${test}"></c:out> 

    <br><br>

    <b>EL EXAMPLE--  </b><br>
    ${test}

    <br><br>
    
    <!-- Demo escape character function of C:OUT 
    	versus using fn:escapeXml with EL 
    	C:OUT avoids XSS hack
    	-->
    <c:set var="test" value="JSTL -<script>alert('Oh no! You've been Hackered!!!')</script>- EL"></c:set>
  
      <b>DEMO ESCAPING--</b>  <br><br>
  
    <b>JSTL c:out EXAMPLE --  </b><br>
     <c:out value="${test}"></c:out>
     <br><br>
     <b>EL ESCAPED EXAMPLE-- </b><br>
      ${fn:escapeXml(test)} 
     <br><br>
     <b> EL PLAIN EXAMPLE --  </b> <br>
     ${test}
    
    
</body>
</html>
