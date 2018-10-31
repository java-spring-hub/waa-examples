package com.eprogrammerz.examples.jpa.service;

import com.eprogrammerz.examples.jpa.domain.Product;

import java.util.List;

public interface ProductService {

    public List<Product> getAll();

    public List<Product> getAllProducts();

    public Product save(Product product);

    public Product find(Long id);


}
 
