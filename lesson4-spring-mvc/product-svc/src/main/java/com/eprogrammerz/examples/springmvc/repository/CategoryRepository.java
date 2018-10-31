package com.eprogrammerz.examples.springmvc.repository;

import com.eprogrammerz.examples.springmvc.domain.Category;

import java.util.List;

public interface CategoryRepository {


    public Category getCategory(int id);

    public List<Category> getAll();


}
 
