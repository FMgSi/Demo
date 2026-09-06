package com.example.demo.service;

import com.example.demo.dto.AddToCartRequest;
import com.example.demo.models.CartItem;
import com.example.demo.models.Product;
import com.example.demo.repository.CartItemRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {
    private final CartItemRepository cartItemRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    public CartItem addToCart(AddToCartRequest addToCartRequest){
        Integer userId = addToCartRequest.getUserId();
        Integer productId = addToCartRequest.getProductId();
        if (productRepository.existsById(productId) && userRepository.existsById(userId)){
            Product product = new Product();
            product = productRepository.findById(addToCartRequest.getProductId()).orElseThrow(() -> new RuntimeException("Khong tim thay san pham id: "));
            if (addToCartRequest.getQuantity() > product.getStockQuantity()){
                if (cartItemRepository.findByUser_UserIdAndProduct_ProductId(userId, productId) != null){
                    CartItem cartItem = cartItemRepository.findByUser_UserIdAndProduct_ProductId(userId, productId);
                    Integer oldQuantity = cartItem.getQuantity();
                    cartItem.setQuantity(oldQuantity + addToCartRequest.getQuantity());
                    return cartItemRepository.save(cartItem);
                } else {
                    CartItem cartItem = new CartItem();
                    cartItem.setUser(userRepository.findById(userId).orElseThrow(() -> new RuntimeException("Khong tim thay userid")));
                    cartItem.setProduct(productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Khong tim thay product")));
                    cartItem.setQuantity(addToCartRequest.getQuantity());
                    return cartItemRepository.save(cartItem);
                }
            } else {
                throw new RuntimeException("Trong kho k du");
            }
        } else {
            throw new RuntimeException("Khong ton tai user hoac la product");
        }
    }

    public List<CartItem> getAllCart(){
        return cartItemRepository.findAll();
    }
}
