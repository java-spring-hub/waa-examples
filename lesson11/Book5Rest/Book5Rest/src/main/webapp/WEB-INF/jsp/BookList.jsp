 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Book List</title>
  	<script type="text/javascript" src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
	<script type="text/javascript" src="<spring:url value="/resource/js/ajax.js"/>"></script>

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
         <td>${book.isbn.ISBNFormatted}</td>
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
 
  <input type="button" value="Add Category" onclick="make_visible('formInput');return false;">

</div>
 
 		<!-- Success - or Validation errors -->
    	<div id="result" style="display:none" >   	
    	    <p id="success" > 
    
    		</p> 
    		<p id="errors" > 
    
    		</p>
    	</div>
 
   	<div id="formInput" style="display:none" > 

	<h3 align="center">Category</h3>

	<!-- No action method handled by AJAX-->
	<form id="categoryForm" method="post">

			<input type="hidden" name="id" value="0">
          
          <p>
            <label for="name"> Name    : </label>
             <input type="text" name="name" id="name" value="" />
        </p>
 
         <p>
            <label for="description"> Description: </label>
            <input id="description" name="description" type="text"/>
        </p>
 
             <input type="button" value="Add Category" onclick="categorySubmit();return false;">
    
    </form>
  <h4 align="center"> 
     <a href="#" onclick="make_hidden('formInput'); make_hidden('result');resetForm('categoryForm');"> <b>EXIT</b> </a> 
  </h4>

</div>
 
</body>
</html>
