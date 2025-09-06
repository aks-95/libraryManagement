package com.akshay.libraryManagement.controller;


import com.akshay.libraryManagement.Respository.BookItemRepository;
import com.akshay.libraryManagement.Respository.BookRepository;
import com.akshay.libraryManagement.Respository.UserRepository;
import com.akshay.libraryManagement.entity.Book;
import com.akshay.libraryManagement.entity.BookItem;
import com.akshay.libraryManagement.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    BookItemRepository bookItemRepository;
    @Autowired
    UserRepository userRepository;

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

    @GetMapping("user")
    Users getUser(@RequestParam(defaultValue = "1") int id){
        return userRepository.findById(id);
    }
    @PostMapping("user")
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
        if (bookItem.getAvailableCount() <= 0) {
            return "No available copies of the book";
        }
        bookItem.setUserId(users.getId());
        bookItem.setAvailableCount(bookItem.getAvailableCount() - 1);
        users.addBookItem(bookItem);
        bookItemRepository.save(bookItem);
        userRepository.save(users);
        return "Book assigned successfully to " + users;

    }
}
