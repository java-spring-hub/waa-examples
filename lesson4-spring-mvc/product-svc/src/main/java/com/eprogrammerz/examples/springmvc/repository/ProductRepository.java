package com.eprogrammerz.examples.springmvc.repository;

import com.eprogrammerz.examples.springmvc.domain.Product;

import java.util.List;

public interface ProductRepository {


    public List<Product> getAll();

    public void save(Product product);

}
 
