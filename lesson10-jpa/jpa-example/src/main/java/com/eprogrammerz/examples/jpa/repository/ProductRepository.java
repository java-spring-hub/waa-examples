package com.eprogrammerz.examples.jpa.repository;


import com.eprogrammerz.examples.jpa.domain.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    // findAll comes with repository
//	    @Query("SELECT p FROM Product p")
//		public List<Product> getAll();

    @Query(value = "select distinct p from Product p left join fetch p.hotLine")
    List<Product> getAllProducts();


    //		List<Product> getProductsByCategory(String category);


}

