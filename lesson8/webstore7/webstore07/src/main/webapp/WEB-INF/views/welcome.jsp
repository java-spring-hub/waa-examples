<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Welcome</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1> ${greeting} </h1>
				<p> ${tagline} </p>
			</div>
				<p>
					<a href="<spring:url value="/products" />" class="btn btn-default">
						<span class="glyphicon-hand-left glyphicon"></span> Products
					</a>
					<a href="<spring:url value="/products/add" />" class="btn btn-default">
						<span class="glyphicon-hand-left glyphicon"></span> Add Product
					</a>
					<a href="<spring:url value="/members/add" />" class="btn btn-default">
						<span class="glyphicon-hand-left glyphicon"></span> Add Member
					</a>

				</p>
		</div>
	</section>
</body>
</html>
