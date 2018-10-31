package com.eprogrammerz.examples.rest.repository;

import com.eprogrammerz.examples.rest.domain.Cart;

public interface CartRepository {

    Cart create(Cart cart);

    Cart read(String cartId);

    void update(String cartId, Cart cart);

    void delete(String cartId);

}
