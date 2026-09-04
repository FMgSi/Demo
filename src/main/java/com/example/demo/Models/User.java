package com.example.demo.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "user")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_Id", nullable = false)
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

    @OneToMany(mappedBy = "user")
    private List<CartItem> cartItems = new ArrayList<>();

    @OneToMany(mappedBy = "order")
    private List<Order> orders = new ArrayList<>();
}
