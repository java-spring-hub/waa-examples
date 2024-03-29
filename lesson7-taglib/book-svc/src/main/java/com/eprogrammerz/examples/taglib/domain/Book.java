package com.eprogrammerz.examples.taglib.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class Book implements Serializable {

    private static final long serialVersionUID = 1520961851058396786L;
    private long id;
    private ISBNumber isbn;
    private String title;
    private Category category;
    private String author;
    @DateTimeFormat(pattern = "MM-dd-yyyy")
//    @DateTimeFormat(iso = ISO.DATE) // yyyy-MM-dd
//    @DateTimeFormat(style = "L-") // July 12, 2001
    //   @DateTimeFormat(pattern="hh:mm:ss")
    private Date publishDate;

    public Book() {
    }

    public Book(long id, ISBNumber isbn, String title,
                Category category, String author) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.category = category;
        this.author = author;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ISBNumber getIsbn() {
        return isbn;
    }

    public void setIsbn(ISBNumber isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }
}
