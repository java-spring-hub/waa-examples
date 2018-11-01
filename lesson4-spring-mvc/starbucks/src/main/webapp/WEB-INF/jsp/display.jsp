<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Starbuck's</title>
    <meta charset="ISO-8859-1">
</head>
<body>

<form action="advice" method="get">
    <select name="roast">
        <option value="-">--Choose Roast--</option>
        <option value="dark">Dark</option>
        <option value="medium">Medium</option>
        <option value="light">Light</option>
    </select>
    <br/><br/>
    <input type="submit" value="Submit"/>
</form>
</body>
</html>