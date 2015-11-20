
// kick off the timer to fire...
      var intervalId = 0;
      intervalId = setInterval(welcome, 750);


var counter= 0; 	// current cell to display
var total = 0;		// number of cells in the row


// Every time the timer fires, We are going to get the number of cells in the row
// and the current cell.. 
// display current student in welcome class 
// and call Duke !!!

function welcome() {
        $.ajax({
            url : 'welcomeStudent',
            success : function(data) {
            	total =  parseInt(data[0]);
            	counter =  parseInt(data[1]);
                $('.welcome').html(data[2]);
            	duke();

            }
        });
    }

// duke hides/shows the DUKE based on counter and total
      function duke() {  
      	      if (counter == 0) {
     	  		// if we have wrapped around, hide the display block
     			$('table.duke tr').find('td').eq(total-1).attr("style", "visibility: hidden");
      	  	  }
     	  	  // hide the last displayed duke
     	  	  else {
     			$('table.duke tr').find('td').eq(counter-1).attr("style", "visibility: hidden");  			 
     	  	  }
    		  $('table.duke tr').find('td').eq(counter).attr("style", "visibility: visible");   
 
      }; 
   

 
    
    
   