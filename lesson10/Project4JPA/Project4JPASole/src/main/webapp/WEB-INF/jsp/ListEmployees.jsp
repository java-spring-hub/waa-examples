<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML>
<html>
<head>
<title>Save Employee</title>
<style type="text/css">@import url(css/main.css);</style>
</head>
<body>
<div id="global">
    <h2>List of Employees</h2>


<table>
		<tr><th>Name</th><th>Phone</th><th>Address</th></tr>

	<c:forEach var="employee" items = "${employees}">
		<tr>
		<td>${employee.firstName} ${employee.lastName}</td>
		<td>${employee.phones[0].number}</td>
		<td>
		<c:forEach var="address" items="${employee.addresses}" >
     			<c:out value="${address.city}" /><br>
		</c:forEach>
		</td>
		</tr><br>
	</c:forEach>
</table>  

   <form action="JPAAssociations" method="get">
           <input id="submit" type="submit"  
                value="JPA Associations">
   </form>
   <br>

 
     <!--form action="employee" method="get">
           <input id="submit" type="submit"  
                value="Add employee"-->
	</form>
    
</div>
</body>
</html>