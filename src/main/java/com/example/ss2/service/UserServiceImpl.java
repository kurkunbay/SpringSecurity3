package com.example.ss2.service;

import com.example.ss2.DAO.UserDAO;
import com.example.ss2.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }


    @Override
    @Transactional
    public List<User> getListOfUsers() {
        return this.userDAO.getListOfUsers();
    }


    @Override
    @Transactional
    public void addUser(User user) {
    this.userDAO.addUser(user);
    }

    @Override
    @Transactional
    public User findById(Long id) {
        return this.userDAO.findById(id);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        this.userDAO.deleteById(id);
    }

    @Override
    @Transactional
    public void update(User user) {
        this.userDAO.update(user);
    }

    @Override
    @Transactional
    public User findByUserName(String username) {
        return this.userDAO.findByUserName(username);
    }
}
