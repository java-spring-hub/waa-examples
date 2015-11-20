<!DOCTYPE HTML>
<html>
<head>
<title>Save Product</title>
<style type="text/css">@import url(css/main.css);</style>
</head>
<body>
<div id="global">
    <h4>The product has been saved.</h4>
    <p>
        <h5>Details:</h5>
        Product Name: ${product.name}<br/>
        Description: ${product.description}<br/>
        Price: $${product.price}<br>
        Hot Line: ${product.hotLine.areaCode}-${product.hotLine.prefix}-${product.hotLine.number}

    </p>
    
    <form action="listproducts" method="get">
           <input id="submit" type="submit"  
                value="List products">
	</form>
    
</div>
</body>
</html>