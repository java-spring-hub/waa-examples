package com.eprogrammerz.examples.webstore.validator;


import com.eprogrammerz.examples.webstore.domain.Product;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.math.BigDecimal;

public class StockMaximumValidator implements ConstraintValidator<StockMaximum, Product>

{
    BigDecimal maxValue = null;

    public void initialize(StockMaximum constraintAnnotation) {

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
        if (unitsInStock > 0) {
            currentValue = unitPrice.multiply(new BigDecimal(unitsInStock));
        }

        if (currentValue.compareTo(maxValue) >= 0)
            return false;

        return true;
    }
}

