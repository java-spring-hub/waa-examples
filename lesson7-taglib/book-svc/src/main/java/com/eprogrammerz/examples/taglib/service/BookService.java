package com.eprogrammerz.examples.taglib.service;

import com.eprogrammerz.examples.taglib.domain.Book;
import com.eprogrammerz.examples.taglib.domain.Category;

import java.util.List;

public interface BookService {

    List<Category> getAllCategories();

    Category getCategory(int id);

    List<Book> getAllBooks();

    Book save(Book book);

    Book update(Book book);

    Book get(long id);

    long getNextId();

}
