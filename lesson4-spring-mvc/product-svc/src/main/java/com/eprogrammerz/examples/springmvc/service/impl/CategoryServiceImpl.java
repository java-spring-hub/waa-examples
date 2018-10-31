package com.eprogrammerz.examples.springmvc.service.impl;

import com.eprogrammerz.examples.springmvc.domain.Category;
import com.eprogrammerz.examples.springmvc.repository.CategoryRepository;
import com.eprogrammerz.examples.springmvc.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Category> getAll() {
        return categoryRepository.getAll();
    }

    @Override
    public Category getCategory(int id) {
        return categoryRepository.getCategory(id);
    }


}
 
