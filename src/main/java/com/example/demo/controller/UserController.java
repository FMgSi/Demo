package com.example.demo.controller;

import com.example.demo.dto.UserRegisterRequest;
import com.example.demo.models.User;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("")
    public User createUser(@RequestBody UserRegisterRequest userRegisterRequest){
        return userService.registerUser(userRegisterRequest);
    }

}
