<!DOCTYPE HTML>
<html>
<head>
<title>Save Product</title>
<style type="text/css">@import url(resource/css/main.css);</style>
</head>
<body>
<div id="global">
    <h2 style="text-align: center;">${appName }</h2>
    <h4>The product has been saved.</h4>
    <p>
        <h5>Details:</h5>
        Product Name: ${product.name}<br/>
        Description: ${product.description}<br/>
        Price: $${product.price}
    </p>
      <form action="product" method="get">
           <input id="submit" type="submit"  
                value="Go to Product">
	</form>
    
</div>
</body>
</html>