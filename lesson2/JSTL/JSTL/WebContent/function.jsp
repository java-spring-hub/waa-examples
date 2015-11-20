<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
<title>Using JSTL Functions</title>
</head>
<body>

<!-- Spit string on space then join with hyphens -->
<c:set var="string1" value="This is first String."/>
<c:set var="string2" value="${fn:split(string1, ' ')}" />
<c:set var="string3" value="${fn:join(string2, '-')}" />

<p>String (3) : ${string3}</p>

<!-- Spit string on hyphens then join with spaces -->
<c:set var="string4" value="${fn:split(string3, '-')}" />
<c:set var="string5" value="${fn:join(string4, ' ')}" />

<p>String (5) : ${string5}</p>

</body>
</html>