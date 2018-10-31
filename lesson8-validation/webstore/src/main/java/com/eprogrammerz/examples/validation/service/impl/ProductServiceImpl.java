package com.eprogrammerz.examples.validation.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.eprogrammerz.examples.validation.domain.Product;
import com.eprogrammerz.examples.validation.domain.repository.ProductRepository;
import com.eprogrammerz.examples.validation.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;

	public List<Product> getAllProducts() {
		return productRepository.getAllProducts();
	}

	public Product getProductById(String productID) {
		return productRepository.getProductById(productID);
	}
	
	public List<Product> getProductsByCategory(String category) {
		return productRepository.getProductsByCategory(category);
	}

	public Set<Product> getProductsByFilter(Map<String, List<String>> filterParams) {
		return productRepository.getProductsByFilter(filterParams);
	}
	
	public void addProduct(Product product) {
		   productRepository.addProduct(product);
	}

}
