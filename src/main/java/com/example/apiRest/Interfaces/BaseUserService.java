package com.example.apiRest.Interfaces;

import com.example.apiRest.Models.User;

import java.util.List;

public interface BaseUserService {

    //FindAll
    List<User> index();

    List<User> searchId(int id);
    List<User> searchName(String name);
    List<User> searchEmail(String email);

    //Create
    User create(User user);

    //UpdateAndFlush
    User update(int id, User user );

    //delete
    User delete(int id);

}
