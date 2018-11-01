<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>

<script type="text/javascript" src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<script type="text/javascript" src="<spring:url value="/resource/js/ajax.js"/>"></script>
<style type="text/css">@import url("<spring:url value="/resource/css/rest.css"/>");</style>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Restful Employee</title>

</head>

<body>
<h1>Add Employee</h1>

<form id="employeeForm" method="post">
    <table cellpadding="0" cellspacing="0" border="1" class="GridOne">
        <tr>
            <td>First Name</td>
            <td><input type="text" name="firstName" id="firstName" value=""></td>
        </tr>
        <tr>
            <td>Last Name</td>
            <td><input type="text" name="lastName" id="lastName" value=""></td>
        </tr>
        <tr>
            <td>Email</td>
            <td><input type="text" name="email" id="email" value=""></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="button" value="Ajax Submit" onclick="makeAjaxCall();"></td>
        </tr>
    </table>
</form>
<!-- Success - or Validation errors -->
<div id="errors" style="display:none">
</div>

<div id="formInput" style="display:none"></div>
</body>
</html>