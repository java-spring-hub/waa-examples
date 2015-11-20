<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
  <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<TITLE>  Spring MVC Mobile with AJAX call</TITLE>
 </head>

<script type="text/javascript"
    src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<script type="text/javascript" src="<spring:url value="/resources/js/welcome.js"/>"></script>

<body>
    <div align="center">
         <h1>Mobile : ${message} </h1> 
        <!--div id="result"></div-->
    </div>   
    
 		<h1 class="welcome" style = "text-align:center"> </h1>  
  		
        <table class="duke">
        <tr>
         <td   style="visibility: hidden;"> <img src="<spring:url value="/resources/images/java2.png"  htmlEscape="true" />" height="200" width="200"  /> </td>
         <td   style="visibility: hidden;"> <img src="<spring:url value="/resources/images/java1.png"  htmlEscape="true" />" height="200" width="200"  /> </td>
         <td   style="visibility: hidden;"> <img src="<spring:url value="/resources/images/java2.png"  htmlEscape="true" />" height="200" width="200"  /> </td>
         <td   style="visibility: hidden;"> <img src="<spring:url value="/resources/images/java1.png"  htmlEscape="true" />" height="200" width="200"  /> </td>
           </tr>
        </table>
        <br>
 
</body>
</html>