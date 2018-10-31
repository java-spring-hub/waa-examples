package com.eprogrammerz.examples.jpa.controller;

import com.eprogrammerz.examples.jpa.domain.Phone;
import com.eprogrammerz.examples.jpa.domain.Product;
import com.eprogrammerz.examples.jpa.service.PhoneService;
import com.eprogrammerz.examples.jpa.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    PhoneService phoneService;

    @RequestMapping(value = {"/product"}, method = RequestMethod.GET)
    public String inputProduct() {
        return "ProductForm";
    }

    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public String saveProduct(Product product) {

// Simulate detached object for phone  
        //   	Phone phone = phoneService.save(product.getHotLine());
        // This is a DIFFERENT phone from one already in product . this one is detached
        // the one in product is transient
        //   	phone.setNumber(1);
        //   	product.setHotLine(phone);
        //----------------------------------------
        //....Demo Cascade
        // Best practice on bidirectional set BOTH ends ["Pretend" no DB]
        product.getHotLine().setProduct(product);
        product = productService.save(product); // insert & [ insert OR Update of phone]

        return "ProductDetails";
    }


    @RequestMapping(value = "/listproducts", method = RequestMethod.GET)
    public String listProducts(Product product, Model model) {


        List<Product> list = productService.getAllProducts();
        model.addAttribute("products", list);

        return "ListProducts";
    }


    @RequestMapping(value = "/addPhone", method = RequestMethod.GET)
    public String addPhone(Model model) {

        Phone phone = new Phone();
        phone.setAreaCode(123);
        phone.setNumber(2367);
        phone.setPrefix(222);

        Product product = new Product();
        product.setName("TestPhone");
        product.setDescription("Test SAVE Phone");
        product.setPrice((float) 44.00);

        // Good OO - set both sides
        phone.setProduct(product);
        product.setHotLine(phone);

        phoneService.save(phone);

        List<Product> list = productService.getAll();
        model.addAttribute("products", list);

        if (!list.isEmpty()) {
            Phone fone = list.get(0).getHotLine();
            System.out.println(fone.getAreaCode());
        }

        return "ListProducts";
    }


}
