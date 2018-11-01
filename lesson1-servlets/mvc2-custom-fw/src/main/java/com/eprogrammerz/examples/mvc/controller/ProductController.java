package com.eprogrammerz.examples.mvc.controller;

import com.eprogrammerz.examples.mvc.framework.annotation.AutoWired;
import com.eprogrammerz.examples.mvc.framework.annotation.RequestMapping;
import com.eprogrammerz.examples.mvc.framework.controller.Controller;
import com.eprogrammerz.examples.mvc.domain.Product;
import com.eprogrammerz.examples.mvc.validator.Validator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ProductController implements Controller {

    @AutoWired
    Validator productValidator;

    @RequestMapping(value = {"/", "/product_input"})
    public String inputProduct(HttpServletRequest request,
                               HttpServletResponse response) {
        return "/WEB-INF/jsp/ProductForm.jsp";
    }

    @RequestMapping(value = {"/save", "/product_save"})
    public String saveProduct(Product product, HttpServletRequest request,
                              HttpServletResponse response) {
        //        ProductValidator productValidator = new ProductValidator();
        List<String> errors = productValidator.validate(product);
        if (errors.isEmpty()) {
            // no validation error, execute action method
            // insert code to save product to the database

            // store product in a scope variable for the view
            request.setAttribute("product", product);
            return "/WEB-INF/jsp/ProductDetails.jsp";
        } else {

            // store errors and product in a scope variable for the view
            request.setAttribute("errors", errors);
            request.setAttribute("form", product);
            return "/WEB-INF/jsp/ProductForm.jsp";
        }
    }
}
