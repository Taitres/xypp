package com.taitres.xypp.service;

import jakarta.annotation.Resource;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServiceTest {

    @Resource
    private UserService userService;

    @Test
    void addUser() {

    }

    @Test
    void userRegister() {
        String userAccount = "test1";
        String userPassword = "123";
        String checkPassword = "12345678";
        String studentId = "202100000000";
        long result = userService.userRegister(userAccount, userPassword, checkPassword,studentId);
        System.out.println(result);


    }
}