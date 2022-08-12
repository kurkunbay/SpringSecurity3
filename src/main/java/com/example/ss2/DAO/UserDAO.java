package com.example.ss2.DAO;

import com.example.ss2.models.User;

import java.util.List;

public interface UserDAO {
    List<User> getListOfUsers();

    void addUser(User user);

    User findById(Long id);

    void deleteById(Long id);

    void update(User user);

    User findByUserName(String username);
}
