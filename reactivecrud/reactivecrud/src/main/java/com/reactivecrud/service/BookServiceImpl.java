package com.reactivecrud.service;

import com.reactivecrud.entity.Book;
import com.reactivecrud.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BookServiceImpl  implements BookService{

    @Autowired
    private BookRepo bookRepo;

    @Override
    public Mono<Book> create(Book book) {
        Mono<Book> createBook=bookRepo.save(book);
        return createBook;
    }

    @Override
    public Flux<Book> getAll() {
        return bookRepo.findAll();
    }

    @Override
    public Mono<Book> get(int bookId) {
        Mono<Book> item = bookRepo.findById(bookId);
        return item;
    }

    @Override
    public Mono<Book> update(Book book, int bookId) {
        Mono<Book> oldBook = bookRepo.findById(bookId);
        return oldBook.flatMap(book1 -> {
            book1.setName(book.getName());
            book1.setAuthor(book.getAuthor());
            book1.setDescription(book.getDescription());
            book1.setPublisher(book.getPublisher());
            return bookRepo.save(book1);
        });

    }

    @Override
    public Mono<Void> delete(int bookId) {
        return bookRepo.findById(bookId)
                .flatMap(book -> bookRepo.delete(book));

    }

    @Override
    public Flux<Book> search(String query) {
        return null;
    }
}
