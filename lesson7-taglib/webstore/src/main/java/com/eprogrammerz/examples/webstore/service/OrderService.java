package com.eprogrammerz.examples.webstore.service;

public interface OrderService {

    void processOrder(String productId, long quantity);
}
