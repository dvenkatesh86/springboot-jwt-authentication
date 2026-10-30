package com.example.security.controller;

import com.example.security.dto.RegisterRequestDTO;
import com.example.security.model.Users;
import com.example.security.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Signature;

@RestController
public class UserController {

    @Autowired
    private UserService userservice;

    @PostMapping("/register")
    public Users register(@Valid @RequestBody RegisterRequestDTO request) {

        return userservice.register(request);
    }
    @PostMapping("/login")
    public String login(@RequestBody Users user){

        return userservice.verify(user);
    }
}
