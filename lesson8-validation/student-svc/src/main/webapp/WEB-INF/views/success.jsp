<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>SUCCESS</title>
</head>
<body>

<h2>Student Save successfully</h2>

<p>
    Student Id: ${student.id}<br>
    Student FirstName: ${student.firstName}<br>
    Student LastName: ${student.lastName}<br>
    Student Email: ${student.email}<br>
    Student Phone: ${student.phone.area}-${student.phone.prefix}-${student.phone.number}<br>


</p>
</body>
</html>