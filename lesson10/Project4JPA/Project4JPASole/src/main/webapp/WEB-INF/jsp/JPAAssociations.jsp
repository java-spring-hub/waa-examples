<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE HTML>
<html>
<head>
<title>Save Employee</title>
<style type="text/css">@import url(css/main.css);</style>
</head>
<body>
<div id="global">
    <h2>List of JPA Association Examples</h2>

    					 <a href="<spring:url value='/product' />"  > OneToOne- Bi - save "Parent" side
					</a><br>
    					 <a href="<spring:url value='/addPhone' />"  > OneToOne Bi - save "child" side
					</a><br>
					 <a href="<spring:url value='/OneToManyUniJoinColumn' />"  > OneToMany Uni - JoinColumn
					</a><br>
					 <a href="<spring:url value='/OneToManyUniJoinTable' />"  > OneToMany Uni - JoinTable
					</a><br>
    
</div>
</body>
</html>