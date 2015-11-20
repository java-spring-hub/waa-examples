<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML>
<html>
<head>
<title>Save Employee</title>
<style type="text/css">@import url(css/main.css);</style>
</head>
<body>
<div id="global">
    <h4>The employee has been saved.</h4>
    <p>
        <h5>Details:</h5>
        Employee Name: ${employee.firstName} ${employee.lastName}<br/>
        Salary: $${employee.salary}<br/>
        
		<c:forEach items="${employee.phones}" var="phone"  >
       
                Phone Number: ${phone.areaCode}-${phone.prefix}-${phone.number}<br/>
        </c:forEach>
		<c:forEach items="${employee.addresses}" var="address"  >
       
                City: ${address.city}  State: ${address.state}<br/>
        </c:forEach>
    </p>
    
    <form action="listemployees" method="get">
           <input id="submit" type="submit"  
                value="List employees">
	</form>
    
</div>
</body>
</html>