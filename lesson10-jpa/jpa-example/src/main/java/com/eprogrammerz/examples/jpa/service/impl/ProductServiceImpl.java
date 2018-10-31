package com.eprogrammerz.examples.jpa.service.impl;

import com.eprogrammerz.examples.jpa.domain.Product;
import com.eprogrammerz.examples.jpa.repository.ProductRepository;
import com.eprogrammerz.examples.jpa.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> getAll() {
        return (List<Product>) productRepository.findAll();
    }

    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }

    public Product save(Product product) {

        return productRepository.save(product);
    }


    public Product find(Long id) {
        return productRepository.findOne(id);

    }


}
 
