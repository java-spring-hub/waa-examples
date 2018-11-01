<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%--@page errorPage="loginerror.jsp"--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
</head>
<body>
<form action="login" method="post">

    <p>Login: </p>
    <p> Name : <input type="text" id="name" name="name"/></p>
    <p> Password : <input type="password" id="password" name="password"/></p>
    <p><input type="submit" value="Submit"/></p>
</form>
</body>
</html>