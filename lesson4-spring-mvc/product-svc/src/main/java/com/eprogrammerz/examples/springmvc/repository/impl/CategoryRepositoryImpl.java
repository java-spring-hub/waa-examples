package com.eprogrammerz.examples.springmvc.repository.impl;

import com.eprogrammerz.examples.springmvc.domain.Category;
import com.eprogrammerz.examples.springmvc.repository.CategoryRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoryRepositoryImpl implements CategoryRepository {

    private List<Category> categories;

    public CategoryRepositoryImpl() {
        categories = new ArrayList<Category>();
        Category computerCategory = new Category(1, "Computer");
        Category sportsCategory = new Category(2, "Sports");
        Category foodCategory = new Category(3, "Food");
        categories.add(computerCategory);
        categories.add(sportsCategory);
        categories.add(foodCategory);
    }

    @Override
    public List<Category> getAll() {
        return categories;
    }

    @Override
    public Category getCategory(int id) {
        for (Category category : categories) {
            if (id == category.getId()) {
                return category;
            }
        }
        return null;
    }


}
 
