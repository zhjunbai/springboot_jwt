package com.example.jwt_learn.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.jwt_learn.entity.User;

public class TokenUtil {
    public static String getToken(User user){
        return JWT.create().withAudience(user.getUsername()).sign(Algorithm.HMAC256(user.getPassword()));
    }
}