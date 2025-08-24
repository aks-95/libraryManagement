package com.akshay.libraryManagement.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Fine {
    int id;
    int userId;
    int bookItemId;
    double amount;
}
