package com.eprogrammerz.examples.springmvc.service.impl;

import com.eprogrammerz.examples.springmvc.domain.Product;
import com.eprogrammerz.examples.springmvc.repository.ProductRepository;
import com.eprogrammerz.examples.springmvc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> getAll() {
        return productRepository.getAll();
    }

    public void save(Product product) {
        productRepository.save(product);
        return;
    }


}
 
