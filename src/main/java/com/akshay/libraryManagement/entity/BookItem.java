package com.akshay.libraryManagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@NoArgsConstructor
public class BookItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    @ManyToOne
    @JoinColumn(name="book_id")
    Book book;


}
