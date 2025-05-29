package com.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.security.entity.User;
import com.security.repository.UserRepository;
import com.security.service.UserService;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    // Register USER
    @PostMapping("/register/user")
    public User registerUser(@RequestBody User user) {
        return userService.register(user, "USER");
    }

    // Register ADMIN
    @PostMapping("/register/owner")
    public User registerAdmin(@RequestBody User user) {
        return userService.register(user, "OWNER");
    }

    @GetMapping("/users")
    public List<User> userList() {
        return userRepository.findAll();
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        return userService.verify(user);
    }
}

