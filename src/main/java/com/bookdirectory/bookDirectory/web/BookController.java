package com.bookdirectory.bookDirectory.web;

import com.bookdirectory.bookDirectory.entity.Book;
import com.bookdirectory.bookDirectory.service.BookServiceImpl;
import com.bookdirectory.bookDirectory.web.model.BookVm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class BookController {


    private final BookServiceImpl bookService;
    private int bookListLength;

    @Autowired
    public BookController(BookServiceImpl bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getBooks() {
        try {
            List<Book> books = bookService.getBooks();
            bookListLength = books.size();
            return ResponseEntity.ok(books);
        } catch (IOException e) {
            //404 error
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") long id) throws IOException{
        Book book  = bookService.getBookById(id);
        if (book != null) {
            return ResponseEntity.ok(book);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/books")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        Book savedBook = null;
        try {
            savedBook = bookService.createBook(book);
        }catch(IOException e) {
            return ResponseEntity.notFound().build();
        }
        //201 status
        return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
    }

    @PutMapping("/books/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable("id") long id, @RequestBody BookVm bookVm) {
        Book book = mapToBookVm(bookVm, id);
        Book updatedBook = null;
        try {

            if (id != book.getId()) {
                return ResponseEntity.badRequest().build();
            }
            updatedBook = bookService.updateBook(book);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(updatedBook, HttpStatus.OK);
    }

    @DeleteMapping("books/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable("id") long id) {
        Book deletedBook = null;
        try {
            deletedBook  = bookService.deleteBook(id);
            if (deletedBook == null) {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(deletedBook, HttpStatus.OK);
    }

    private Book mapToBookVm(BookVm bookVm, long id) {
        Book newBook = new Book();
        newBook.setId(id);
        newBook.setTitle(bookVm.getTitle());
        newBook.setAuthor(bookVm.getAuthor());
        newBook.setSynopsis(bookVm.getSynopsis());
        newBook.setReleaseDate(bookVm.getReleaseDate());
        return newBook;
    }



}
