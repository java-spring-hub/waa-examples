package mum.edu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mum.edu.domain.Book;
import mum.edu.repository.ApplicationRepository;

@Service
public class BookServiceImpl implements BookService {
    
    @Autowired
    private CategoryService categoryService;


    /*
     * this implementation is not thread-safe
     */
    @Autowired
     private ApplicationRepository applicationRepository;
    
     @Override
    public List<Book> getAllBooks() {
        return applicationRepository.getBooks();
    }

    @Override
    public Book save(Book book) {
        book.setId(getNextId());
        applicationRepository.getBooks().add(book);
        return book;
    }

    @Override
    public Book get(long id) {
        for (Book book : applicationRepository.getBooks()) {
            if (id == book.getId()) {
                return book;
            }
        }
        return null;
    }
    
    @Override
    public Book update(Book book) {
        int bookCount = applicationRepository.getBooks().size();
        for (int i = 0; i < bookCount; i++) {
            Book savedBook = applicationRepository.getBooks().get(i);
            if (savedBook.getId() == book.getId()) {
                applicationRepository.getBooks().set(i, book);
                return book;
            }
        }
        return book;
    }
    
    @Override
    public long getNextId() {
        // needs to be locked
        long id = 0L;
        for (Book book : applicationRepository.getBooks()) {
            long bookId = book.getId();
            if (bookId > id) {
                id = bookId;
            }
        }
        return id + 1;
    }
}
