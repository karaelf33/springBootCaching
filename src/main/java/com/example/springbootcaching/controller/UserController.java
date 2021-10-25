package com.example.springbootcaching.controller;

import com.example.springbootcaching.entity.User;
import com.example.springbootcaching.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    private final UserService userService;

    @Autowired
    UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/all")
    public List<User> getAllUsers() {
        return userService.findall();
    }

    @PostMapping(value = "/updateUser")
    public User updateUser(User user) {
        return userService.updateUser(user);
    }
}
