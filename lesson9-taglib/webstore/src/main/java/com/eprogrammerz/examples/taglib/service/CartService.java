package com.eprogrammerz.examples.taglib.service;

import com.eprogrammerz.examples.taglib.domain.Cart;

public interface CartService {

    Cart create(Cart cart);

    Cart read(String cartId);

    void update(String cartId, Cart cart);

    void delete(String cartId);

}
