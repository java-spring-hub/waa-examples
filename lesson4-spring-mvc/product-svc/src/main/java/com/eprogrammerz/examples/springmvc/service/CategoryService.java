package com.eprogrammerz.examples.springmvc.service;

import com.eprogrammerz.examples.springmvc.domain.Category;

import java.util.List;

public interface CategoryService {
    public Category getCategory(int id);

    public List<Category> getAll();
}
 
