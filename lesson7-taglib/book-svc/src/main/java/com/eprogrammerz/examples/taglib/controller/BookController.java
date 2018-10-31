package com.eprogrammerz.examples.taglib.controller;

import com.eprogrammerz.examples.taglib.domain.Book;
import com.eprogrammerz.examples.taglib.domain.Category;
import com.eprogrammerz.examples.taglib.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    // Used by all Controller handler methods 
    // book list is added to model as "books"...
    @ModelAttribute("books")
    List<Book> addBookList(Model model) {

        return bookService.getAllBooks();

    }

    @RequestMapping(value = {"/", "/book_list"})
    public String listBooks(Model model) {

// List is added to model by @ModelAttribute on addBookList method

        return "BookList";
    }

    @RequestMapping(value = "/addBook", method = RequestMethod.GET)
    public String inputBook(@ModelAttribute("newBook") Book book, Model model) {

        // Domain Object for search
        model.addAttribute("bookSearch", new Book());


        List<Category> categories = bookService.getAllCategories();
        model.addAttribute("categories", categories);
        return "BookAddForm";
    }

    // from BookAddForm
    @RequestMapping(value = "/addBook", method = RequestMethod.POST)
    public String saveBook(@ModelAttribute("newBook") Book book) {

        // Category id from form
        Category category = bookService.getCategory(book.getCategory().getId());
        book.setCategory(category);

        bookService.save(book);

        return "redirect:/book_list";
    }

    // Book to edit from bookList.jsp -  gets id from @PathVariable
    @RequestMapping(value = "/book_edit/{id}", method = RequestMethod.GET)
    public String editBook(Model model, @PathVariable("id") long id) {

        // Domain Object for search
        model.addAttribute("bookSearch", new Book());

        // Domain Object for edit from @PathVariable
        Book book = bookService.get(id);
        model.addAttribute("editBook", book);

        List<Category> categories = bookService.getAllCategories();
        model.addAttribute("categories", categories);

        return "BookEditForm";
    }

    // Book to edit From Drop down list on BookAddForm.jsp & BookEditForm.jsp
    @RequestMapping(value = "/editBook", method = RequestMethod.POST)
    public String editBook(@ModelAttribute("bookSearch") Book searchBook, Model model) {

        // Domain object for edit from @ModelAttribute "searchBook"
        Book book = bookService.get(searchBook.getId());
        model.addAttribute("editBook", book);

        // Category list for form
        List<Category> categories = bookService.getAllCategories();
        model.addAttribute("categories", categories);

        return "BookEditForm";
    }

    // book to save from BookEditForm
    @RequestMapping(value = "/book_update", method = RequestMethod.POST)
    public String updateBook(@ModelAttribute("editBook") Book book) {

        // Category id from form - get Category
        Category category = bookService.getCategory(book.getCategory().getId());
        book.setCategory(category);

        bookService.update(book);

        return "redirect:/book_list";
    }


}