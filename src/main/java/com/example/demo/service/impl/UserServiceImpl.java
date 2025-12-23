package com.example.demo.service.impl;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final List<User> users = new ArrayList<>();

    @Override
    public User registerUser(User user) {
        if (user.getRole() == null) {
            user.setRole("MONITOR");
        }
        user.setCreatedAt(LocalDateTime.now());
        users.add(user);
        return user;
    }

    @Override
    public User findByEmail(String email) {
        return users.stream()
                .filter(u -> u.getEmail().equals(email))
                .findFirst()
                .orElse(null);
    }

    @Override
    public User findById(Long id) {
        return users.stream()
                .filter(u -> id.equals(u.getId()))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<User> getAllUsers() {
        return users;
    }
}
