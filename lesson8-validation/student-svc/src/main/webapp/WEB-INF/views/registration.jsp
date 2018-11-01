<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Registration</title>
    <style type="text/css">@import url("<c:url value="/css/main.css"/>");</style>

</head>
<body>

<div id="global">
    <form:form commandName="student" action="/registration/add" method="post">
        <fieldset>
            <legend>Registration Form</legend>
            <p>
                <form:errors path="*" cssStyle="color : red;"/>
            </p>
            <p>
                <label for="firstName">First Name: </label>
                    <form:input path="firstName"/>

            <div style="text-align: center;">
                <form:errors path="firstName" cssStyle="color : red;"/>
            </div>
            </p>

            <p>
                <label for="lastName">Last Name: </label>
                    <form:input path="lastName"/>

            <div style="text-align: center;">
                <form:errors path="lastName" cssStyle="color : red;"/>
            </div>
            </p>

            <p>
                <label for="email">Email: </label>
                    <form:input path="email"/>

            <div style="text-align: center;">
                <form:errors path="email" cssStyle="color : red;"/>
            </div>
            </p>

            <p>
                <label for="birthday">Date Of Birth: </label>
                <form:input path="birthday" id="birthday" placeholder="32/12/1992"/>
                <form:errors path="birthday" cssStyle="color : red;"/>
            </p>
            <p>
                <label for="gender">Gender: </label>
                    <form:radiobutton path="gender" id="gender"/> Male
                    <form:radiobutton path="gender" id="gender"/> Female
            <div style="text-align: center;">
                <form:errors path="gender" cssStyle="color : red;"/>
            </div>
            </p>

            <p>
                <label for="phone">Phone Number: </label>
                    <form:input path="phone.area" id="area" cssStyle=" width:30px;" maxlength="3"/>-
                    <form:input path="phone.prefix" id="prefix" cssStyle=" width:30px;" maxlength="3"/>-
                    <form:input path="phone.number" id="number" cssStyle=" width:50px;" maxlength="4"/>

            <div style="text-align: center;">
                <form:errors path="phone.number" cssStyle="color : red;"/>
            </div>

            <div style="text-align: center;">
                <form:errors path="phone.area" cssStyle="color : red;"/>
            </div>

            <div style="text-align: center;">
                <form:errors path="phone.prefix" cssStyle="color : red;"/>
            </div>
            </p>

            <p id="buttons">
                <input id="reset" type="reset" tabindex="4">
                <input id="submit" type="submit" tabindex="5"
                       value="Add Student">
            </p>
        </fieldset>
    </form:form>
</div>
</body>
</html>