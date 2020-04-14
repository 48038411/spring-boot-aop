package com.soft1851.springboot.aop.service;

import com.soft1851.springboot.aop.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserServiceTest {
    @Resource
    private UserService userService;
    @Test
    void login() {
        User user = new User();
        user.setUserName("guoruichang");
        user.setPassword("Qq48038411");
        System.out.println(userService.login(user));
    }
}