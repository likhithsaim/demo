package com.example.demo.service;

import com.example.demo.model.AdminUser;
import com.example.demo.model.Reader;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    public List<Reader> getUsers() {
        return userRepository.getUsers();
    }

    public List<AdminUser> getAdmins() {
        return userRepository.getAdmins();
    }

    public List<Reader> getUsersOfBook(Integer departmentId, String subject, String title) {
        return  userRepository.getUsersOfBook(departmentId, subject, title);
    }
}
