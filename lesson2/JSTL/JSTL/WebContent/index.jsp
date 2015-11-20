<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Now You See It, Now You Don't</title>
</head>
<body>

<!-- This is how you implement 'if/else' -->
<!-- We are figuring out the button value -->
<c:choose>
  <c:when test="${hidden eq 'Hide'}">
     <c:set var = "hiddenvalue" value="Show" />
     <c:set var = "buttonvalue" value="Show text field" />
  </c:when>
  <c:otherwise>
     <c:set var = "hiddenvalue" value="Hide" />
     <c:set var = "buttonvalue" value="Remove text field" />
  </c:otherwise>
</c:choose>

<!-- Here's our form -->
<form action="offon.do" method="get"><br/>

	<!-- If show -->
	<c:if test = "${hidden ne 'Hide'}">
	Now You See It
	</c:if>

	<!-- If hide -->
	<c:if test = "${hidden eq 'Hide'}">
	Now You Don't<br/>
	</c:if>

	<!-- If show THEN show text input field-->
	<c:if test = "${hidden ne 'Hide'}">
	 <input type = "text" name="text" value = "Some text"/><br/>
	 </c:if>
	<p>
		<select name="phone">
	    	<option value="-">  --Select phone </option>
	
	  		<c:forEach var="phone" items="${phonesMap}">
	    		<option value="${phone.key}" > ${phone.value}</option>
			</c:forEach>
	    </select>
	</p>
	
	<p>	 
	<input type = "submit" value ="${buttonvalue}"/>
	<input type = "hidden" name = "hiddenfield" value = '${hiddenvalue}'/>
</p>	
	
</form>
</br>
        <a href="foreach.jsp" >c:foreach</a>
        <br></br>
        <a href="setAndOut.jsp">c:out</a>
        <br></br>
        <a href="format.jsp">format Number</a>
        <br></br>
        <a href="function.jsp">String Function</a>

</body>
</html>