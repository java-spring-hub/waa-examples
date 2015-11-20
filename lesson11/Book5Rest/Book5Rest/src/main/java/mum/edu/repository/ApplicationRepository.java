package mum.edu.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mum.edu.domain.Book;
import mum.edu.domain.Category;
import mum.edu.domain.ISBNumber;
import mum.edu.service.CategoryService;

@Repository
public class ApplicationRepository {

	private List<Book> books;
	private List<Category> categories;
	
	public ApplicationRepository() {
        categories = new ArrayList<Category>();
        categories.add(new Category(1, "Computing"));
        categories.add(new Category(2, "Travel"));
        categories.add(new Category(3, "Health"));
        
        ISBNumber isbn = new ISBNumber(111,222,333);
        Category category = categories.get(1);
        books = new ArrayList<Book>();
         books.add(new Book(1L, isbn, "Servlet & JSP: A Tutorial", category, "Budi Kurniawan"));
         books.add(new Book(2L, isbn, "C#: A Beginner's Tutorial", category, "Jayden Ky"));

	}
	
	public  List<Book> getBooks() {
		return books;
	}

 
	public  List<Category> getCategories() {
		return categories;
	}

 

}
