<!DOCTYPE HTML>
<html>
<head>
    <title>Add Product Form</title>
    <style type="text/css">@import url(css/main.css);</style>
</head>
<body>

<div id="global">
    <form action="product" method="post">
        <fieldset>
            <legend>Add a product</legend>
            <p>
                <label for="name">Product Name: </label>
                <input type="text" id="name" name="name"
                       tabindex="1">
            </p>
            <p>
                <label for="description">Description: </label>
                <input type="text" id="description"
                       name="description" tabindex="2">
            </p>
            <p>
                <label for="price">Price: </label>
                <input type="text" id="price" name="price"
                       tabindex="3">
            </p>
            <p>
                <label for="areaCode">Hot Line: </label>
                <input type="text" id="areaCode" size="3"
                       name="hotLine.areaCode" tabindex="2">

                <input type="text" size="3"
                       name="hotLine.prefix" tabindex="3">

                <input type="text" size="4"
                       name="hotLine.number" tabindex="4">
            </p>

            <p id="buttons">
                <input id="reset" type="reset">
                <input id="submit" type="submit" tabindex="5"
                       value="Add Product">
            </p>
        </fieldset>
    </form>
</div>
</body>
</html>
