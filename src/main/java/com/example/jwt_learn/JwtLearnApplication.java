package com.example.jwt_learn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.example.jwt_learn.dao")
@SpringBootApplication
public class JwtLearnApplication {
    public static void main(String[] args) {
        SpringApplication.run(JwtLearnApplication.class, args);
    }
}
