package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UserRegisterRequest {
    private String username;
    private String fullName;
    private String passwordHash;
    private String email;
    private String phoneNumber;
    private String address;
}
