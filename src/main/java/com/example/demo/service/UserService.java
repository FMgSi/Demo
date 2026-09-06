package com.example.demo.service;

import com.example.demo.dto.UserRegisterRequest;
import com.example.demo.models.Role;
import com.example.demo.models.User;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final ProductRepository productRepository;

    public User registerUser(UserRegisterRequest userRegisterRequest){
        if (!userRepository.existsByUsername(userRegisterRequest.getUsername()) && !userRepository.existsByEmail(userRegisterRequest.getEmail())){
            User user = new User();
            user.setUsername(userRegisterRequest.getUsername());
            user.setFullName(userRegisterRequest.getFullName());
            user.setEmail(userRegisterRequest.getEmail());
            user.setAddress(userRegisterRequest.getAddress());
            user.setPhoneNumber(userRegisterRequest.getPhoneNumber());
            user.setPasswordHash(userRegisterRequest.getPasswordHash());
            user.setCreateAt(LocalDateTime.now());
            user.setRole(roleRepository.findById(1).orElseThrow(() -> new RuntimeException("Khong tim thay role 1")));
            return userRepository.save(user);
        } else {
            throw new RuntimeException("Bi trung username hoac email");
        }
    }
}
