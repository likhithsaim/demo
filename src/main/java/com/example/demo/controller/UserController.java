package com.example.demo.controller;

import com.example.demo.service.UserService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin
@RestController
@EnableAutoConfiguration
public class UserController {
    private final UserService userService;

    @Autowired
    UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/users")
    public String getUsers() {
        return new Gson().toJson(userService.getUsers());
    }

    @GetMapping(value = "/admins")
    public String getAdmins() {
        return new Gson().toJson(userService.getAdmins());
    }

    @GetMapping(value = "/usersOfBook")
    public String getUsersOfBook(@RequestParam("departmentId") Integer departmentId, @RequestParam("subject") String subject, @RequestParam("title") String title) {
        System.out.println(departmentId + " " + subject + " " + title);
        return new Gson().toJson(userService.getUsersOfBook(departmentId, subject, title));
    }
}
