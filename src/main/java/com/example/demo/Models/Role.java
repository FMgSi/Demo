package com.example.demo.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "role")
@Getter
@Setter
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_Id", nullable = false, length = 150)
    private int RoleId;

    private String RoleName;

    @OneToMany(mappedBy = "role")
    private List<User> users = new ArrayList<>();
}
