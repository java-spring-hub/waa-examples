<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE HTML>
<html>
<head>
<title>Test XSS</title>
 </head>
<body>

       <c:set var="test" value="<script>alert('Oh no! You have been hacked!!')</script>"></c:set>
       <c:set var="testJS" value="javascript:alert('Oh no! You have been hacked!!')"></c:set>
 
 JAVASCRIPT Prompt:<br> 
 <a href="${testJS}" />Strait JS</a><br>
 <a href="<spring:url value="${testJS}/XSS" /> " >Strait Spring:URL JS</a><br>
  <a href="<spring:url value="/${testJS}" /> " >  Spring:URL JS with path</a><br>
 
  SCRIPT Element:<br> 
   <a href="${test}" />Strait javascript </a><br>
 <a href="<spring:url value="${test}/XSS" /> " >Strait Spring:URL javascript</a><br>
  <a href="<spring:url value="/${test}" /> " >  Spring:URL javascript with path</a><br>
 
  
 
  <!-- 
   <a href= "<spring:url value="/addXSS?userName= ${test }"/> " > spring:url NO param</a>
 <br>
-->

<!-- Query Parameter passing (Avoids XSS injection attack - URL encoding) -->
<!--
<spring:url value="/addXSS" var="addBook_url" >
   <spring:param name="userName" value="${test }"/>
   
</spring:url>
<a href="${addBook_url}">Spring param</a><br/>

 -->
 
 
<!-- Query Parameter passing (Avoids XSS injection attack - URL encoding) -->
<spring:url value="{xss}" var="addBook_tt" >
   <spring:param name="xss" value="${testJS}"/>
   
</spring:url>
<a href="${addBook_tt}">Spring param template</a><br/>

   <a href= "<spring:url value="/TaddXSS/${testJS }"/> " > spring:url Template</a>
 <br>
 


</body>
</html>
