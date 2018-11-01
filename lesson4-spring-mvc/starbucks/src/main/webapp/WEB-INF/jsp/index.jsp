<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Starbuck's</title>
</head>
<body>
<h2>Ask for advice about your favorite roast:</h2>
<p/>
<form action="action/advice" method="get">
    <select name="roast" disabled="disabled">
        <option value="-">--Choose Roast--</option>
        <option value="dark">Dark</option>
        <option value="medium">Medium</option>
        <option value="light">Light</option>
    </select>
    <br/><br/>
    <input type="submit" value="Submit" disabled="disabled"/>
</form>
<div id='advice'>

    <c:if test="${errors != null}">

        <p id="errors">
            Error(s)!
        <ul>
            <c:forEach var="error" items="${errors}">
                <li>${error}</li>
            </c:forEach>
        </ul>


    </c:if>
</div>
<p/>
Login:
<form action="login" method="post">
    Name: <input type="text" name="name" size="9"/><br/>
    Password: <input type="password" name="password" size="9"/><br/>
    <br/>
    <input type="submit" value="Log In"/>
</form>
</body>
</html>