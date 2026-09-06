package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddToCartRequest {
    private Integer userId;
    private Integer productId;
    private Integer quantity;
}
