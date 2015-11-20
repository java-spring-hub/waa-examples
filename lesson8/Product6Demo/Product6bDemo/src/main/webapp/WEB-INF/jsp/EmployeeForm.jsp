<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>
<title>Add Employee Form</title>
<style type="text/css">@import url("<c:url value="/css/main.css"/>");</style>
</head>
<body>

<div id="global">
<form:form commandName="employee" action="employee_save" method="post">
    <fieldset>
        <legend>Add an employee</legend>
  		<p>
  		     <form:errors path="*" cssStyle="color : red;" /> 
        </p>
        <p>
            <label for="firstName">First Name: </label>
           <form:input path="firstName" />
 	
 		  	<div style="text-align: center;">
 				<form:errors path="firstName" cssStyle="color : red;" /> 
 			</div>
       </p>
        <p>
            <label for="lastName">Last Name: </label>
           <form:input path="lastName" />
 
 		  	<div style="text-align: center;">
 				<form:errors path="lastName" cssStyle="color : red;" /> 
 			</div>
       </p>

        <p>
            <label for="birthDate">Date Of Birth: </label>
            <form:input path="birthDate" id="birthDate" />
 			<form:errors path="birthDate" cssStyle="color : red;" /> 
        </p>
        <p>
            <label for="id">ID: </label>
            <form:input path="id" id="id" />
 
 		  	<div style="text-align: center;">
 				<form:errors path="id" cssStyle="color : red;" /> 
 			</div>
       </p>
    <h4>Address:</h4>
        <p>
            <label for="street">Street: </label>
            <form:input path="address.street" id="street" />
 
 		  	<div style="text-align: center;">
 				<form:errors path="address.street" cssStyle="color : red;" /> 
 			</div>
       </p>
        <p>
            <label for="state">State: </label>
            <form:input path="address.state" id="state" />
 
 		  	<div style="text-align: center;">
 				<form:errors path="address.state" cssStyle="color : red; " /> 
 			</div>
       </p>
        <p>
            <label for="zipCode">Zip: </label>
            <form:input path="address.zipCode" id="zipCode" />
 	
 		  	<div style="text-align: center;">
 				<form:errors path="address.zipCode" cssStyle="color : red; " /> 
 			</div>
       </p>
        <p id="buttons">
            <input id="reset" type="reset" tabindex="4">
            <input id="submit" type="submit" tabindex="5" 
                value="Add Employee">
        </p>
    </fieldset>
</form:form>
</div>
</body>
</html>
