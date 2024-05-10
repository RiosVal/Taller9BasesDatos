package com.pragma.redis.redistest.controller;

import com.pragma.redis.redistest.model.User;
import com.pragma.redis.redistest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public void saveUser(@RequestBody User user) {
        userService.saveUser(user);
    }

    @GetMapping
    public List<User> findAllUsers() {
        return userService.findAllUsers();
    }

    @GetMapping("/{id}")
    public User findUserById(@PathVariable String id) {
        return userService.findUserById(id);
    }

    @PutMapping("/{id}")
    public void updateUser(@PathVariable String id, @RequestBody User user) {
        user.setId(id); // Ensure the ID is set from the path variable
        userService.updateUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
    }
}