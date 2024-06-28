package com.omkar.BookApplication.controller;

import com.omkar.BookApplication.entity.Book;
import com.omkar.BookApplication.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    private final BookService bookService;

    @Autowired // it will inject dependency of BookService in the BookController class, it is called as dependency injection in SpringBoot.
    //this is a constructor injection
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/addBook")
    public ResponseEntity<Book> addBook(@RequestBody Book book){
        Book savedBook = bookService.addBook(book);
        return ResponseEntity.ok(savedBook);
    }
    @GetMapping("/getBook/{bookName}")
    public ResponseEntity<Book> getBookByName(@PathVariable("bookName") String name){
        final Book bookByName = bookService.getBookByName(name);
        return ResponseEntity.ok(bookByName);
    }
    @GetMapping("/getBooks")
    public ResponseEntity<List<Book>> getAllBooks(){
        List<Book> books = bookService.getAllBooks();
        if(!books.isEmpty()){
            return new ResponseEntity<>(books, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/updateBook")
    public ResponseEntity<Book> updateBook(@RequestBody Book book){
        Book updatedBook = bookService.updateBook(book);
        return ResponseEntity.ok(updatedBook);
    }
    @DeleteMapping("/deleteBook/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable("id") Integer id){
        bookService.deleteBook(id);
        return ResponseEntity.ok().build();
    }
}
