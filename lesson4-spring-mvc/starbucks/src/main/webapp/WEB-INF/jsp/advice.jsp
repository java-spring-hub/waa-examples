<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Starbuck's</title>
</head>
<body>

<form action="login" method="get">
    <h2>Star Buck's ${roast} Roast Coffees:</h2>
    <table>
        <c:forEach var="advice" items="${advices}">
            <tr>
                <td>
                    <c:out value="${advice}"></c:out>
                </td>
            </tr>
        </c:forEach>
    </table>
    <input type="submit" value="Back">
</form>
</body>
</html>