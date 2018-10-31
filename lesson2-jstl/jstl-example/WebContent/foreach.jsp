<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import = "java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>For Each</title>
</head>
<body>
<%! ArrayList<String> list = new ArrayList<String>(); %>
<%
//set things up
list.add("Jim");
list.add("Bob");
list.add("Harold");
list.add("Suzie");
request.setAttribute("list", list);

%>
forEach populating a table<br>

<table border = '1'>
<c:forEach var="personsname" items = "${list}">
	<tr><td>${personsname}</td></tr>
</c:forEach>
</table>	


<p>
forEach populating a select list<br>
    <select name= "vendorIndex">	
	  	<c:forEach var="i" begin="0" end="3">
		    <option value="${i}" > ${list[i]} </option>   
 	 	</c:forEach>
    </select>
</p>

</body>
</html>