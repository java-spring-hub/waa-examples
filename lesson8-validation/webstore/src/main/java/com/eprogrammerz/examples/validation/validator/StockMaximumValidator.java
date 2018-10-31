package com.eprogrammerz.examples.validation.validator;



	import java.math.BigDecimal;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

    import com.eprogrammerz.examples.validation.domain.Product;

public class StockMaximumValidator implements ConstraintValidator<StockMaximum, Product>

	{
		BigDecimal maxValue = null;
		
  	    public void initialize( StockMaximum constraintAnnotation) {
	    	
  	    	// get annotation parameter
 	    	int maximum = constraintAnnotation.maximum();
	    	maxValue = new BigDecimal(maximum);

	    }

	    @Override
	    public boolean isValid(Product product, final ConstraintValidatorContext context) {
		    BigDecimal unitPrice;
		    Long unitsInStock;

		    unitsInStock = product.getUnitsInStock();
		    unitPrice = product.getUnitPrice();
		    
	    	BigDecimal currentValue = new BigDecimal(0);
	    	if (unitsInStock > 0 ) {
	    	 currentValue = unitPrice.multiply(new BigDecimal(unitsInStock));
	    	}
	    	
	    	if (currentValue.compareTo(maxValue) >= 0)
	    		return false;
	    	
	    	return true;
	    }
	}

