package com.akshay.libraryManagement.Respository;

import com.akshay.libraryManagement.entity.Book;
import com.akshay.libraryManagement.entity.BookItem;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookItemRepository extends CrudRepository<BookItem,Integer> {
    BookItem findById(int id);
}
