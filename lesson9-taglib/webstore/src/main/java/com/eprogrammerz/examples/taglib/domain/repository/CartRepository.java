package com.eprogrammerz.examples.taglib.domain.repository;

import com.eprogrammerz.examples.taglib.domain.Cart;

public interface CartRepository {

    Cart create(Cart cart);

    Cart read(String cartId);

    void update(String cartId, Cart cart);

    void delete(String cartId);

}
