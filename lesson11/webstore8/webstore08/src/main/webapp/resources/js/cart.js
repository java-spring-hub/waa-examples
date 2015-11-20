$(document).ready(function() {
	
	var cartId;
	
	addToCart = function(productId){
			$.ajax({
		 		url: '/webstore08/rest/cart/add/' + productId,
		 		type: 'PUT',
				dataType: "json",
				success: function(response){
	 		 		alert("Product Successfully added to the Cart!");

				},
				error: function(){						
					alert('Error while request..');
				}
			});
		}

	   removeFromCart = function(productId) {
			$.ajax({
				url: '/webstore08/rest/cart/remove/'+ productId,
		 		type: 'PUT',
				dataType: "json",
			 	 success: function (response) {
		 		 		location.reload(true);
					},
					error: function(){						
						alert('Error while request..');
			 	 } 
		   });
	   }

	   
	   
	 // Click on Product [row]  in cart
       $("#cart_table").find("tr").click(function() {  
	       	var productId=  $(this).find("td:first").html();
				showProduct(productId);
	          });

	   // Get product object from Server...
	   function showProduct(productId) {
			$.ajax({
				url: '/webstore08/rest/cart/showProduct',
		 		type: 'GET',
		 		async:false,
				dataType: "json",
				data:'id=' + productId,
			 	 success: function (response) {
		 		 		 displayProduct(response);
					},
					error: function(){						
 			 	 } 
		   });
	   }
	   
	   function displayProduct(product) {
	 
			$('#result').html("");
			$("#result").append('<h4 align="right"> <a href="#" onclick="toggle_visibility(\'result\');"><b>CLOSE</b> </a> </h4>');
			$("#result").append( '<H3 align="center"> Product Information <H3>');                
			$("#result").append( '<H4 align="center">' + product.productId + '<H4>');                
			$("#result").append( '<H4 align="center">' + product.name + '<H4>');               	 
			$("#result").append( '<H4 align="center">' + product.unitPrice + '<H4>');                
			$("#result").append( '<H4 align="center">' + product.manufacturer + '<H4>');                
			$("#result").append( '<H4 align="center">' + product.category + '<H4>');                
			$("#result").attr("style", "display: block")
	 		} 
	 
	   toggle_visibility = function(id) {
	       var e = document.getElementById(id);
	       if(e.style.display == 'block')
	          e.style.display = 'none';
	       else
	          e.style.display = 'block';
	    }	   
//------------------TO BE Implemented-------------------------------------	   
	   
		 getCartId = function( ) {
				$.ajax({
					url: '/webstore08/rest/cart/getId/',
					type: 'GET',
					success : function(id) {
					 		 		 cartId = id;
					 	 		}
			});
		 }


 
		 refreshCart = function() {
		 		getCartId();
				$.ajax({
					url: '/webstore8/rest/cart/'+ cartId,
					type: 'GET',
					dataType: "json",
					success : function(cartData) {
  					 }
			});
		 }


});

 