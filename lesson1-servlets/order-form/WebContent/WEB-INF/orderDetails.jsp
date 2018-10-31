<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<link rel="stylesheet" type="text/css" href="resources/mystyle.css">
<meta charset="ISO-8859-1">
<h4>Order</h4>
</head>
<body>
 		 <table> 
        	<tr> 
        		<td>Name:</td><td>${name }</td>
        	</tr>    	
			<tr>
        		<td>Address:</td> <td>${address }</td> 
        	</tr>  	
			<tr> 
				<td>Country:</td> <td> ${country }</td>
			</tr>
		
			<tr> 
				<td>Shipping Instructions:</td> 
				<td> 
					<c:forEach var="instruction" items = "${instructions}">
						${instruction} <br>
					</c:forEach>
				</td> 
        	</tr>  	
			
			<tr> 
				<td>Delivery Method:</td>
				<td>${deliveryMethod}  </td> 
         	</tr> 
   
 			<tr> 
        		<td>Catalog Request:</td>       
				<td> ${catalogRequest} </td> 
       		</tr>
       		
         </table> 
         	
 
</body>
</html>