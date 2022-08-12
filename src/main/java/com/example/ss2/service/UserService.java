package com.example.ss2.service;

import com.example.ss2.models.User;

import java.util.List;

public interface UserService {
    List<User> getListOfUsers();

    void addUser(User user);

    User findById(Long id);

    void deleteById(Long id);

    void update(User user);

    User findByUserName(String username);
}
