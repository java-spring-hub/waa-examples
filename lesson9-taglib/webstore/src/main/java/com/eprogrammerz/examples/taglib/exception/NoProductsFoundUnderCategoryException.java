package com.eprogrammerz.examples.taglib.exception;

//Either activate @ResponseStatus OR "activate method in @ControllerAdvice
//@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="No products found under this category")
public class NoProductsFoundUnderCategoryException extends RuntimeException {

    private static final long serialVersionUID = 3935230281455340039L;
}
