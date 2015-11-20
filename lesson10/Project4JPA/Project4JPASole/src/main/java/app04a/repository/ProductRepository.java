package app04a.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import app04a.domain.Product;

	@Repository
	public interface ProductRepository extends  CrudRepository<Product, Long> 
	{
	
 	    // findAll comes with repository
//	    @Query("SELECT p FROM Product p")
//		public List<Product> getAll();
 	
	    @Query(value = "select distinct p from Product p left join fetch p.hotLine")
	    List<Product> getAllProducts();

	    
	    //		List<Product> getProductsByCategory(String category);

 
	}

