package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.UserDao;
import com.example.entity.User;

@Service
public class UserService {

    @Autowired
    UserDao dao;   

    public void addUser(User user) {
        dao.saveUser(user);   
    }
    
    public User getUser(int id) {
        return dao.getUserById(id);
    }
    
    public List<User> getAllUsers() {
        return dao.getAllUsers();
    }
    
    public void deleteUser(int id) {
        dao.deleteUser(id);
    }
    
    public void updateUser(User user) {
        dao.updateUser(user);
    }
    
}