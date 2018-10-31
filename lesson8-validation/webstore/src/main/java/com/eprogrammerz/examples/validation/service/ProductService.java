package com.eprogrammerz.examples.validation.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.eprogrammerz.examples.validation.domain.Product;

public interface ProductService {

	List<Product> getAllProducts();

	Product getProductById(String productID);
	
	List<Product> getProductsByCategory(String category);

	Set<Product> getProductsByFilter(Map<String, List<String>> filterParams);
	
	void addProduct(Product product);
}
