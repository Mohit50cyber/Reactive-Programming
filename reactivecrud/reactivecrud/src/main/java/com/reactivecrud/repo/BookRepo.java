package com.reactivecrud.repo;

import com.reactivecrud.entity.Book;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepo extends ReactiveCrudRepository<Book,Integer> {
}
