package com.userService.userService.controller;

import com.userService.userService.entities.User;
import com.userService.userService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    UserRepository repository;

    @GetMapping("/hello")
    public static String gethello() {
        return "Hello World";
    }

    @GetMapping("/search/{id}")
    public User search(@PathVariable long id) {
        User user = repository.findById(id);
        return user;
    }

    @PostMapping(path = "/insertuser/", consumes = "application/json", produces = "application/json")

    public void saveUser(@RequestBody User user) {
        repository.save(user);
        return;
    }

}