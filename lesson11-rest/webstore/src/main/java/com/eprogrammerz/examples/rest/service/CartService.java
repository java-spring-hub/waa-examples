package com.eprogrammerz.examples.rest.service;

import com.eprogrammerz.examples.rest.domain.Cart;

public interface CartService {

    Cart create(Cart cart);

    Cart read(String cartId);

    void update(String cartId, Cart cart);

    void delete(String cartId);

}
