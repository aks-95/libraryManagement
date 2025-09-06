package com.akshay.libraryManagement.Respository;

import com.akshay.libraryManagement.entity.Users;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<Users,Integer> {
    List<Users>findByName(String name);
    Users findById(int id);
}
