package com.example.jwt_learn.service;

import com.example.jwt_learn.dao.UserDao;
import com.example.jwt_learn.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    public User findUserById(int id){
        return userDao.findUserById(id);
    }
    public User findUserByUsername(String username){
        return userDao.findUserByUsername(username);
    }
}
