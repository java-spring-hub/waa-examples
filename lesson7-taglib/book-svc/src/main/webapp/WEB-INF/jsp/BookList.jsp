<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Book List</title>
<style type="text/css">@import url("<spring:url value="/css/main.css"/>");</style>
</head>
<body>

<div id="global">
<h1>Book List</h1>

<!-- Query Parameter passing  -->
<spring:url value="/addBook" var="addBook_url" >
</spring:url>
<a href="${addBook_url}">Add Book</a><br/>

 
 
<table>
<tr>
    <th>Category</th>
    <th>Title</th>
    <th>ISBN</th>
    <th>Author</th>
    <th>Date;</th>
</tr>
<c:forEach items="${books}" var="book">
    <tr>
        <td>${book.category.name}</td>
        <td>${book.title}</td>
   <!-- Without spring:eval will display default toString value...
        With spring:eval will use formatter print method 
        form:form fields handle this automatically
        -->
<%--          <td>${book.isbn}</td>
 --%> 
         <td><spring:eval expression="book.isbn" /></td>

         <td>${book.author}</td>
        <td><spring:eval expression="book.publishDate" /></td>
        
        <!-- Spring:url for handling Spring template/@PathVariable -->
        <spring:url value="/book_edit/{id}"  var="edit" >
   				<spring:param name="id" value="${book.id}" />
 		</spring:url>
         
        <td><a href="${edit}">Edit</a></td>
    </tr>
</c:forEach>
</table>
</div>
 
</body>
</html>
