package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "orderDetail")
@Getter
@Setter
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_Detail_Id", nullable = false)
    private int orderDetailId;

    private int quantity;
    private BigDecimal unitPrice;

    @ManyToOne
    @JoinColumn(name = "order_Id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_Id")
    private Product product;
}
