package app04a.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app04a.domain.Product;
import app04a.repository.ProductRepository;
import app04a.service.ProductService;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
  	public List<Product> getAll() {
		return (List<Product>) productRepository.findAll();
	}
	
  	public List<Product> getAllProducts() {
		return productRepository.getAllProducts();
	}
	
	public Product save(Product product) {
		
		return productRepository.save(product);
	}
	
	
	public Product find(Long id) {
		return productRepository.findOne(id);
	 
	}
	
	
		   
}
 
