<!DOCTYPE HTML>
<html>
<head>
<title>Session</title>
<style type="text/css">@import url(resource/css/main.css);</style>
</head>
<body>
<div id="global">
    <h2 style="text-align: center;">${appName }</h2>
    <h4>This is Forward or Redirect.</h4>
 
     <h5>If this is Redirect. - we "automatically" have @RequestParam...</h5>
  		<h4>${redirectParamTest}</h4>
  
     <h5>If this is Forward. - we should see Request Attribute...</h5>
 			<h4>${requestAttribute.description}</h4>
  
  <form action="home" method="get">
           <input id="submit" type="submit"  
                value="Go Home">
</form>
  
 </body>
</html>