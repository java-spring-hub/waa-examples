package com.eprogrammerz.examples.rest.service;

import com.eprogrammerz.examples.rest.domain.Product;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface ProductService {

    List<Product> getAllProducts();

    Product getProductById(String productID);

    List<Product> getProductsByCategory(String category);

    Set<Product> getProductsByFilter(Map<String, List<String>> filterParams);

    void addProduct(Product product);
}
