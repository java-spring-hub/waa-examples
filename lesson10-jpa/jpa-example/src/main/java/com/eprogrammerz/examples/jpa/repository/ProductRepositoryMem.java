package com.eprogrammerz.examples.jpa.repository;

import com.eprogrammerz.examples.jpa.domain.Product;

import java.util.List;

public interface ProductRepositoryMem {


    public List<Product> getAll();

    public void save(Product product);


}
 
