package com.pragma.redis.redistest.service;
import com.pragma.redis.redistest.model.User;
import com.pragma.redis.redistest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public User findUserById(String id) {
        return userRepository.findById(id);
    }

    public void updateUser(User user) {
        userRepository.update(user);
    }

    public void deleteUser(String id) {
        userRepository.delete(id);
    }
}