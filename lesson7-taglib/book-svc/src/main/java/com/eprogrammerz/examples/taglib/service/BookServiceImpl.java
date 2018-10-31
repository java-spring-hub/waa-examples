package com.eprogrammerz.examples.taglib.service;

import com.eprogrammerz.examples.taglib.domain.Book;
import com.eprogrammerz.examples.taglib.domain.Category;
import com.eprogrammerz.examples.taglib.domain.ISBNumber;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    /*
     * this implementation is not thread-safe
     */
    private List<Category> categories;
    private List<Book> books;

    public BookServiceImpl() {
        categories = new ArrayList<Category>();
        Category computingCategory1 = new Category(1, "Computing");
        Category travelCategory = new Category(2, "Travel");
        Category healthCategory = new Category(3, "Health");
        categories.add(computingCategory1);
        categories.add(travelCategory);
        categories.add(healthCategory);

        ISBNumber isbn = new ISBNumber(111, 222, 333);
        books = new ArrayList<Book>();
        books.add(new Book(1L, isbn,
                "Servlet & JSP: A Tutorial",
                computingCategory1, "Budi Kurniawan"));
        books.add(new Book(2L, isbn,
                "C#: A Beginner's Tutorial",
                computingCategory1, "Jayden Ky"));
    }

    @Override
    public List<Category> getAllCategories() {
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

    @Override
    public List<Book> getAllBooks() {
        return books;
    }

    @Override
    public Book save(Book book) {
        book.setId(getNextId());
        books.add(book);
        return book;
    }

    @Override
    public Book get(long id) {
        for (Book book : books) {
            if (id == book.getId()) {
                return book;
            }
        }
        return null;
    }

    @Override
    public Book update(Book book) {
        int bookCount = books.size();
        for (int i = 0; i < bookCount; i++) {
            Book savedBook = books.get(i);
            if (savedBook.getId() == book.getId()) {
                books.set(i, book);
                return book;
            }
        }
        return book;
    }

    @Override
    public long getNextId() {
        // needs to be locked
        long id = 0L;
        for (Book book : books) {
            long bookId = book.getId();
            if (bookId > id) {
                id = bookId;
            }
        }
        return id + 1;
    }
}
