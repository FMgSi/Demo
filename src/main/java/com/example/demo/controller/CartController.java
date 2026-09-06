package com.example.demo.controller;

import com.example.demo.dto.AddToCartRequest;
import com.example.demo.models.CartItem;
import com.example.demo.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carts")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;

    @PostMapping("")
    public CartItem createCartItem(@RequestBody AddToCartRequest request){
        return cartService.addToCart(request);
    }

    @GetMapping("/{id}")
    public List<CartItem> getAllCart(@PathVariable Integer id){
        return cartService.getAllCart();
    }
}
