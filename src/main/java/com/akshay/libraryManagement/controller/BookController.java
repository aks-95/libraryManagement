package com.akshay.libraryManagement.controller;

import com.akshay.libraryManagement.Respository.BookItemRepository;
import com.akshay.libraryManagement.Respository.BookRepository;
import com.akshay.libraryManagement.entity.Book;
import com.akshay.libraryManagement.entity.BookItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/book")
@RestController
public class BookController {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    BookItemRepository bookItemRepository;

    @GetMapping("/id")
    Book getBook(@RequestParam(defaultValue = "1") int id){
        return bookRepository.findById(id);
    }
    @GetMapping("/all")
    List<Book> getBook(){
        return (List<Book>) bookRepository.findAll();
    }

    @GetMapping("/name")
    List<Book> getBookByName(String name){
        return  bookRepository.findByName(name);
    }
    @PostMapping("/save")
    Book setBook(@RequestBody Book book){
        book.setAvailableCount(book.getCount());
        return bookRepository.save(book);
    }
}
