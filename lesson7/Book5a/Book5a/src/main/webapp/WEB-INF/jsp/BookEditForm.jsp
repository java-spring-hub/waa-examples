<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>
<title>Edit Book Form</title>
<style type="text/css">@import url("<c:url value="/css/main.css"/>");</style>
</head>
<body>
<spring:url var = "editBook" value="/editBook" />
<div id="rightList"> 
	<form:form modelAttribute="bookSearch"  action= "${editBook}"   method="post">
  <p>
            	<label for="bookList"><spring:message code="book.book" /> </label>
             	<form:select id="booklist" path="id" 
                	items="${books}" itemLabel="title" itemValue="id"/>
  
             <input id="submit" type="submit" value="Edit Book">
</p>
    </form:form >
</div>

<spring:url var = "book_update" value="/book_update" />


<div id="global">
<form:form commandName="editBook" action= "${book_update}" >
    <fieldset>
        <legend>Edit a book</legend>
        <form:hidden path="id"/>
        <p>
            <label for="category">Category: </label>
             <form:select id="category" path="category.id" items="${categories}"
                itemLabel="name" itemValue="id"/>
        </p>
        <p>
            <label for="title">Title: </label>
            <form:input id="title" path="title"/>
        </p>
        <p>
            <label for="author">Author: </label>
            <form:input id="author" path="author"/>
        </p>
        <p>
            <label for="isbn">ISBN: </label>
            <form:input id="isbn" path="isbn"/>
        </p>
           <p>
            <label for="publishDate">Publish Date: </label>
            <form:input path="publishDate" id="publishDate" />
         </p>
        
        <p id="buttons">
            <input id="submit" type="submit" value="Update Book">
        </p>
    </fieldset>
</form:form>
</div>
</body>
</html>
