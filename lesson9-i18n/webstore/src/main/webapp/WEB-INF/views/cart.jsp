<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">

  	<script type="text/javascript" src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
	<script type="text/javascript" src="<spring:url value="/resource/js/cart.js"/>"></script>

<title>Cart</title>
<style type="text/css">@import url("<c:url value="/resource/css/cart.css"/>");</style>
</head>
<body>
	<section>
 			<div id="prod" class="container"  >
   			     <div id="result" style="display:none" > </div>
			</div>
 	</section>	

 	<section class="container" >
 		<div>

			<div>
				 <a href="#" class="btn btn-success pull-right"> <span
					class="glyphicon-shopping-cart glyphicon"></span> Check out
				</a>
			</div>
			<table class="table table-hover">
				<tr>
					<th>---ID---</th>
					<th>Name</th>
					<th>Unit price</th>
					<th>Quantity</th>
					<th>Price</th>
					<th>Action</th>
				</tr>
			</table>
	<table id="cart_table" class="table table-hover">
	
		<c:forEach  var="item" items ="${cart.cartItems}" >
				<tr>
					<td>${item.value.product.productId}</td>
					<td>${item.value.product.name}</td>
					<td>${item.value.product.unitPrice}</td>
					<td>${item.value.quantity}</td>
					<td>${item.value.totalPrice}</td>
					<td><a href="#" class="label label-danger" onclick="removeFromCart('${item.value.product.productId}');"> <span
							class="glyphicon glyphicon-remove" /></span> Remove
					</a></td>
				</tr>
		</c:forEach>
  
				<tr>
					<th></th>
					<th></th>
					<th>Grand Total</th>
					<th>${cart.grandTotal}</th>
					<th></th>
				</tr>
			</table>
			
			<a href="<spring:url value="/products" />" class="btn btn-default">
						<span class="glyphicon-hand-left glyphicon"></span> Continue shopping
			</a>
		</div>
	</section>
</body>
</html>
