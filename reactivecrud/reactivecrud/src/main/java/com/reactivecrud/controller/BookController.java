package com.reactivecrud.controller;

import com.reactivecrud.entity.Book;
import com.reactivecrud.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    //create
    @PostMapping
    public Mono<Book> create(@RequestBody Book book){
        return bookService.create(book);
    }

    //get All books
    @GetMapping
    public Flux<Book> getAllBooks(){
        return bookService.getAll();
    }

    //get single book
    @GetMapping("/{bookId}")
    public Mono<Book> getSingle(@PathVariable Integer bookId){
        return bookService.get(bookId);
    }

    //update the book
    @PutMapping("/{bookId}")
    public Mono<Book> updateBook(@RequestBody Book book,@PathVariable Integer bookId){
        return bookService.update(book,bookId);
    }
    //delete the book
    @DeleteMapping
    public Mono<Void> delete(@PathVariable int bookId){
        return bookService.delete(bookId);
    }



}
