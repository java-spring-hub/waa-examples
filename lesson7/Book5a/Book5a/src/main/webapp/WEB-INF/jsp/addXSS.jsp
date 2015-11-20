<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE HTML>
<html>
<head>
<title>Test XSS</title>
 </head>
<body>

	<!--
				Input Form for XSS User: ${userName }<br>
    -->
		<form action="addXss"  >
 
		</form>




</body>
</html>
