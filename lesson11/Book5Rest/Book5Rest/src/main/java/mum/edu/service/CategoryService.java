package mum.edu.service;

import java.util.List;

import mum.edu.domain.Book;
import mum.edu.domain.Category;

public interface CategoryService {
    
    List<Category> getAllCategories();
    Category getCategory(int id);
    Category save(Category category);
	Category update(Category category);
	public Category getCategoryByName(String name);
}
