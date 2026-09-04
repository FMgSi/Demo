package com.example.demo.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "user")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int UserId;

    private String UserName;
    private String PasswordHash;
    private String Email;
    private String PhoneNumber;
    private String Address;
    private LocalDateTime CreateAt;

    @ManyToOne
    @JoinColumn(name = "role_Id")
    private Role role;
}
