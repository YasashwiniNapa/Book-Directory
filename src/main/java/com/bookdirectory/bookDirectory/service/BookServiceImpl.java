package com.bookdirectory.bookDirectory.service;

import com.bookdirectory.bookDirectory.entity.Book;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
public class BookServiceImpl implements BookService {

    private final ObjectMapper objectMapper;
    private long uniqueId = 100;

    public BookServiceImpl(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public List<Book> getBooks() throws IOException {
        ClassPathResource classPathResource = new ClassPathResource("bookdata.json");
        return objectMapper.readValue(classPathResource.getInputStream(), new TypeReference<>() {});
    }

    @Override
    public Book getBookById(long id) throws IOException {
        List<Book> books = getBooks();
        return books.stream()
                .filter(book -> book.getId() == id)
                .findFirst()
                .orElse(null);

    }

    @Override
    public Book createBook(Book newBook) throws IOException {
        List<Book> books = getBooks();
        newBook.setId(uniqueId++);
        books.add(newBook);
        return newBook;

    }

    public Book updateBook(Book updatedBookData) throws IOException {
        Book updatedOldBook = getBookById(updatedBookData.getId());
        updatedOldBook.setTitle(updatedBookData.getTitle());
        updatedOldBook.setAuthor(updatedBookData.getAuthor());
        updatedOldBook.setSynopsis(updatedBookData.getSynopsis());
        updatedOldBook.setReleaseDate(updatedBookData.getReleaseDate());
        return updatedOldBook;
    }

    public Book deleteBook(long id) throws IOException {
        List<Book> books = getBooks();
        Book deletedBook = getBookById(id);
        books.removeIf(book -> book.getId() == id);
        return deletedBook;
    }

}
