package com.akshay.libraryManagement.controller;

import com.akshay.libraryManagement.Respository.BookItemRepository;
import com.akshay.libraryManagement.Respository.BookRepository;
import com.akshay.libraryManagement.entity.Book;
import com.akshay.libraryManagement.entity.BookItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/bookItem")
@RestController
public class BookItemController {
    @Autowired
    BookItemRepository bookItemRepository;


    @GetMapping("/id")
    BookItem getBookItem(@RequestParam(defaultValue = "1") int id){
        return bookItemRepository.findById(id);
    }
    @GetMapping("/all")
    List<BookItem> getAllBookItem(){
        return (List<BookItem>) bookItemRepository.findAll();
    }

    @PostMapping("save")
    BookItem setBookItem(@RequestBody BookItem bookItem){
        return bookItemRepository.save(bookItem);
    }
}
