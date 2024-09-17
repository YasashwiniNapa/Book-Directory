package com.bookdirectory.bookDirectory.service;

import com.bookdirectory.bookDirectory.entity.Book;

import java.util.List;

public interface BookService {

    List<Book> getBooks() throws Exception;

    Book getBookById(long id) throws Exception;

    Book createBook(Book book) throws Exception;

    Book updateBook(Book book) throws Exception;

    Book deleteBook(long id) throws Exception;
}
