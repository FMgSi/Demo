package com.example.demo.repository;


import com.example.demo.models.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Integer> {
    CartItem findByUser_UserIdAndProduct_ProductId(Integer userId, Integer productId);
}
