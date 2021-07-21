package com.example.jwt_learn.dao;

import com.example.jwt_learn.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    User findUserById(int id);
    User findUserByUsername(String username);
}
