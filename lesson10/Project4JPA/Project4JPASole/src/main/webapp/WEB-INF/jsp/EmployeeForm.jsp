<!DOCTYPE HTML>
<html>
<head>
<title>Add Employee Form</title>
<style type="text/css">@import url(css/main.css);</style>
</head>
<body>

<div id="global">
<form action="employee" method="post">
    <fieldset>
        <legend>Add a employee</legend>
        <p>
            <label for="firstName">First Name: </label>
            <input type="text" id="firstName" name="firstName" 
                tabindex="1">
        </p>
        <p>
            <label for="lastName">Last Name: </label>
            <input type="text" id="lastName" name="lastName" 
                tabindex="1">
        </p>
        <p>
            <label for="salary">Salary: </label>
            <input type="text" id="salary" name="salary" 
                tabindex="3">
        </p>
        <p>
            <label for="areaCode">Area Code: </label>
            <input type="text" id="areaCode" 
                name="phone.areaCode" tabindex="2">
 
              <input type="text"   size="3"
                name="phone.prefix" tabindex="3">
 
             <input type="text"  size="4"
                name="phone.number" tabindex="4">
 
        </p>
        <p id="buttons">
            <input id="reset" type="reset" tabindex="4">
            <input id="submit" type="submit" tabindex="5" 
                value="Add Employee">
        </p>
    </fieldset>
</form>
</div>
</body>
</html>
