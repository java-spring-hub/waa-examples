package mum.edu.service;

import java.util.List;

import mum.edu.domain.Book;
import mum.edu.domain.Category;

public interface BookService {
    
    List<Book> getAllBooks();
    Book save(Book book);
    Book update(Book book);
    Book get(long id);
    long getNextId();

}
