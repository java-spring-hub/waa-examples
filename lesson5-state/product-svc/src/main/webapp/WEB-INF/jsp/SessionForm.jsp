<!DOCTYPE HTML>
<html>
<head>
<title>Add Product Form</title>
<style type="text/css">@import url(resource/main.css);</style>
</head>
<body>
 
<div id="global">
    <h2 style="text-align: center;">${appName }</h2>
 <form action="postSession" method="post">
    <fieldset>
        <legend>This is the Session "GET FORM" page</legend>
      <p id="buttons">
             <input id="submit" type="submit"  value="Submit Session Form">
        </p>
    </fieldset>
</form>

 	<form action="delegateSession" method="get">
              <input id="submit" type="submit"  
              value="Delegate Session Controller">
	</form>

        <form action="home" method="get">
           <input id="submit" type="submit"  
                value="Go to Home">
	</form>
 
</div>
</body>
</html>
