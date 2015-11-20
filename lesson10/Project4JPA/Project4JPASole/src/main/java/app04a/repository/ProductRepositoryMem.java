package app04a.repository;

import java.util.List;

import app04a.domain.Product;

 public interface ProductRepositoryMem   {
	
 
	
	public List<Product> getAll();
	
	public void save(Product product);
	
	
		   
}
 
