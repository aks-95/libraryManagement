package com.akshay.libraryManagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Users {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<BookItem> getBookItemList() {
        return bookItemList;
    }

    public void setBookItemList(List<BookItem> bookItemList) {
        this.bookItemList = bookItemList;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String name;
    String email;
    @OneToMany
    @JoinColumn(name="book_item_id")
    List<BookItem> bookItemList;

    public void addBookItem(BookItem bookItem) {
        this.bookItemList.add(bookItem);
    }
}
