package com.eprogrammerz.examples.mvc.validator;

import com.eprogrammerz.examples.mvc.domain.Product;

import java.util.ArrayList;
import java.util.List;

public class ValidatorImpl implements Validator {

    public List<String> validate(Object object) {
        List<String> errors = new ArrayList<String>();

        Product product = (Product) object;
        String name = product.getName();
        if (name == null || name.trim().isEmpty()) {
            errors.add("Product must have a name");
        }
        Double price = product.getPrice();
        if (price == null) {
            errors.add("Product must have a price");
        }
        return errors;
    }
}
