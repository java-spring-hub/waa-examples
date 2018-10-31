package com.eprogrammerz.examples.taglib.service.impl;

import com.eprogrammerz.examples.taglib.domain.Product;
import com.eprogrammerz.examples.taglib.domain.repository.ProductRepository;
import com.eprogrammerz.examples.taglib.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ProductRepository productRepository;

    public void processOrder(String productId, long quantity) {
        Product productById = productRepository.getProductById(productId);

        if (productById.getUnitsInStock() < quantity) {
            throw new IllegalArgumentException("Out of Stock. Available Units in stock" + productById.getUnitsInStock());
        }

        productById.setUnitsInStock(productById.getUnitsInStock() - quantity);
    }
}
