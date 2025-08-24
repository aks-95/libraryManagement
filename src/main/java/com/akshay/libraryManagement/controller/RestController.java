package com.akshay.libraryManagement.controller;


import com.akshay.libraryManagement.Respository.BookItemRepository;
import com.akshay.libraryManagement.Respository.BookRepository;
import com.akshay.libraryManagement.entity.Book;
import com.akshay.libraryManagement.entity.BookItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    BookItemRepository bookItemRepository;

    @GetMapping("book")
    Book getBook(@RequestParam(defaultValue = "1") int id){
         return bookRepository.findById(id);
    }
    @PostMapping("book")
    Book setBook(@RequestBody Book book){
        return bookRepository.save(book);
    }

    @GetMapping("bookItem")
    BookItem getBookItem(@RequestParam(defaultValue = "1") int id){
        return bookItemRepository.findById(id);
    }

    @PostMapping("bookItem")
    BookItem setBookItem(@RequestBody BookItem bookItem){
        return bookItemRepository.save(bookItem);
    }

}
