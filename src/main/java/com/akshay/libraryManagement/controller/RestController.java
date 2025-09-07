package com.akshay.libraryManagement.controller;


import com.akshay.libraryManagement.Respository.BookItemRepository;
import com.akshay.libraryManagement.Respository.BookRepository;
import com.akshay.libraryManagement.Respository.UserRepository;
import com.akshay.libraryManagement.entity.Book;
import com.akshay.libraryManagement.entity.BookItem;
import com.akshay.libraryManagement.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController

@RequestMapping("/user")
public class RestController {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    BookItemRepository bookItemRepository;
    @Autowired
    UserRepository userRepository;


    @GetMapping("id")
    Users getUser(@RequestParam(defaultValue = "1") int id){
        return userRepository.findById(id);
    }
    @GetMapping("name")
    List<Users> getUser(String name){
        if(name==null) return (List<Users>) userRepository.findAll();
        return userRepository.findByName(name);
    }
    @PostMapping("update")
    Users setUser(@RequestBody Users users){
        return userRepository.save(users);
    }
    @PatchMapping("AssignBook")
    String assignBook(@RequestParam int bookItemId,@RequestParam int userId) {
        BookItem bookItem = bookItemRepository.findById(bookItemId);
        Users users = userRepository.findById(userId);
        if (bookItem == null || users == null) {
            return "BookItem or User not found";
        }
        if(bookItem.getUserId()!=0){
            return "BookItem already assigned to another user";
        }
        if (bookItem.getBook().getAvailableCount() <= 0) {
            return "No available copies of the book";
        }
        bookItem.setUserId(users.getId());
        bookItem.getBook().setAvailableCount(bookItem.getBook().getAvailableCount() - 1);
        users.addBookItem(bookItem);
        bookItemRepository.save(bookItem);
        userRepository.save(users);
        return "Book assigned successfully to " + users.getId() +  " " + users.getName();

    }
}
