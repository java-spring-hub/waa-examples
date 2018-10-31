package com.eprogrammerz.examples.springmvc.service;

import com.eprogrammerz.examples.springmvc.domain.Product;

import java.util.List;

public interface ProductService {

    public List<Product> getAll();

    public void save(Product product);


}
 
