<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Starbuck's</title>
</head>
<body>
<c:choose>
    <c:when test="${user eq null}">
        You'll need to Login to get Starbucks Advice!</br>

        <form action="login">
            <p><input type="submit" value="Login"/></p>
        </form>
    </c:when>
    <c:otherwise>

        <h3> Hi ${user.name}, how are you today?</h3>

        <h2>Ask for advice about your favorite roast:</h2>

        <form method="post">
            <select name="roast">
                <option value="dark">Dark</option>
                <option value="medium">Medium</option>
                <option value="light">Light</option>
            </select>

            <p><input type="submit" value="Submit"/></p>
        </form>

        <form action="logout" method="post">
            <p><input type="submit" value="Logout"/></p>
        </form>
    </c:otherwise>
</c:choose>


</body>
</html>