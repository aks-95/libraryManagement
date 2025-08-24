package com.akshay.libraryManagement.Respository;

import com.akshay.libraryManagement.entity.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book,Integer> {
    List<Book>findByName(String name);
    Book findById(int id);
}
