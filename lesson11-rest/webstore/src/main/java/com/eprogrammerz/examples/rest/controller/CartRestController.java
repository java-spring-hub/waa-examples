package com.eprogrammerz.examples.rest.controller;

import com.eprogrammerz.examples.rest.domain.Cart;
import com.eprogrammerz.examples.rest.domain.CartItem;
import com.eprogrammerz.examples.rest.domain.Product;
import com.eprogrammerz.examples.rest.exception.ProductNotFoundException;
import com.eprogrammerz.examples.rest.service.CartService;
import com.eprogrammerz.examples.rest.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/rest/cart")
public class CartRestController {

    @Autowired
    private CartService cartService;

    @Autowired
    private ProductService productService;

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody
    Cart create(@RequestBody Cart cart) {
        return cartService.create(cart);
    }

    @RequestMapping(value = "/add/{productId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void addItem(@PathVariable String productId, HttpServletRequest request) {

        String sessionId = request.getSession(true).getId();
        Cart cart = cartService.read(sessionId);
        if (cart == null) {
            cart = cartService.create(new Cart(sessionId));
        }

        Product product = productService.getProductById(productId);
        if (product == null) {
            throw new IllegalArgumentException(new ProductNotFoundException(productId, null));
        }

        cart.addCartItem(new CartItem(product));
        System.out.printf("Product ITEM: %s\n", product.getName());
        System.out.printf("CART ITEM: %s\n", cart.getCartItems().size());

        cartService.update(sessionId, cart);
    }

    @RequestMapping(value = "/remove/{productId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void removeItem(@PathVariable String productId, HttpServletRequest request) {

        String sessionId = request.getSession(true).getId();
        Cart cart = cartService.read(sessionId);
        if (cart == null) {
            cart = cartService.create(new Cart(sessionId));
        }

        Product product = productService.getProductById(productId);
        if (product == null) {
            throw new IllegalArgumentException(new ProductNotFoundException(productId, null));
        }

        cart.removeCartItem(new CartItem(product));

        cartService.update(sessionId, cart);
    }

    @RequestMapping(value = "/showProduct", produces = "application/json")
    public @ResponseBody
    Product getRestProduct(@RequestParam("id") String productId) {
//			String productId = request.getParameter("id");

        Product product = productService.getProductById(productId);
        return product;
    }

    // TODO:
    @RequestMapping(value = "/getId", method = RequestMethod.GET)
    public @ResponseBody
    String getCartId(HttpSession session) {
        return session.getId();
    }

    // TODO:
    @RequestMapping(value = "/{cartId}", method = RequestMethod.GET)
    public @ResponseBody
    Cart read(@PathVariable(value = "cartId") String cartId) {
        Cart cart = cartService.read(cartId);

        return cart;
    }


    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Illegal request, please verify your payload")
    public void handleClientErrors(Exception ex) {
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Internal server error")
    public void handleServerErrors(Exception ex) {
    }
}
