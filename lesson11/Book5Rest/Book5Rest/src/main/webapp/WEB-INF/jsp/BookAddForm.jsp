<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE HTML>
<html>
<head>
<title>Add Book Form</title>
<style type="text/css">@import url("<c:url value="/css/main.css"/>");</style>
</head>
<body>

<spring:url var = "editBook" value="/editBook" />
<div id="rightList"> 
	<form:form modelAttribute="bookSearch"  action= "${editBook}"  method="post">
  <p>
            	<label for="bookList"><spring:message code="book.book" /> </label>
             	<form:select id="booklist" path="id" 
                	items="${books}" itemLabel="title" itemValue="id"/>
  
             <input id="submit" type="submit" value="Edit Book">
</p>
    </form:form >
</div>

 
<spring:url var = "addBook" value="/addBook" />
<div id="global">
<form:form modelAttribute="newBook"  action= "${addBook }" method="post">
    <fieldset>
        <legend>Add a book</legend>
  		<p>
  		     <form:errors path="*" cssStyle="color : red;" /> 
        </p>
        <p>
            <label for="category"><spring:message code="book.category" /> </label>
             <form:select id="category" path="category.id" 
                items="${categories}" itemLabel="name" itemValue="id"/>
        </p>
         
        <p>
            <label for="title"><spring:message code="book.title" /> </label>
            <form:input id="title" path="title"/>
  		  	<div style="text-align: center;">
 				<form:errors path="title" cssStyle="color : red;" /> 
 			</div>
        </p>
        <p>
            <label for="author">Author: </label>
            <form:input id="author" path="author"/>
        </p>
        <p>
            <label for="isbn"><spring:message code="book.ISBN" /> </label>
            <form:input id="isbn" path="isbn"/>
   		  	<div style="text-align: center;">
 				<form:errors path="isbn" cssStyle="color : red;" /> 
 			</div>
        </p>
           <p>
            <label for="publishDate">Publish Date: </label>
            <form:input path="publishDate" id="publishDate" />
         </p>
        
        <p id="buttons">
             <input id="submit" type="submit" value="Add Book">
        </p>
    </fieldset>
</form:form>
</div>
</body>
</html>
