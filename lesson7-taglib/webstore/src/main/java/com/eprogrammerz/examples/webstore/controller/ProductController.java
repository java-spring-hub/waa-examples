package com.eprogrammerz.examples.webstore.controller;

import com.eprogrammerz.examples.webstore.domain.Product;
import com.eprogrammerz.examples.webstore.exception.NoProductsFoundUnderCategoryException;
import com.eprogrammerz.examples.webstore.exception.ProductNotFoundException;
import com.eprogrammerz.examples.webstore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;


    @RequestMapping
    public String list(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "products";
    }

    @RequestMapping("/all")
    public ModelAndView allProducts() {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("products", productService.getAllProducts());
        modelAndView.setViewName("products");
        return modelAndView;
    }

    @RequestMapping("/{category}")
    public String getProductsByCategory(Model model, @PathVariable("category") String category) {
        List<Product> products = productService.getProductsByCategory(category);

        if (products == null || products.isEmpty()) {
            throw new NoProductsFoundUnderCategoryException();
        }

        model.addAttribute("products", products);
        return "products";
    }

    @RequestMapping("/product")
    public String getProductById(Model model, @RequestParam("id") String productId) {
        Product product = productService.getProductById(productId);
        model.addAttribute("product", product);
        return "product";
    }


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getAddNewProductForm(@ModelAttribute("newProduct") Product newProduct) {
        return "addProduct";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String processAddNewProductForm(@ModelAttribute("newProduct") @Valid Product productToBeAdded, BindingResult result, HttpServletRequest request) {
        if (result.hasErrors()) {
            return "addProduct";
        }

        productService.addProduct(productToBeAdded);
        return "redirect:/products";
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ModelAndView handleError(HttpServletRequest req, ProductNotFoundException exception) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("invalidProductId", exception.getProductId());
        mav.addObject("exception", exception);
        mav.addObject("url", req.getRequestURL() + "?" + req.getQueryString());
        mav.setViewName("productNotFound");
        return mav;
    }


}
