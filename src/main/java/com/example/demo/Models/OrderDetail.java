package com.example.demo.Models;

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
    @Column(name = "order_Detaild_Id", nullable = false)
    private int OrderDetailId;

    private int Quantity;
    private BigDecimal UnitPrice;

    @ManyToOne
    @JoinColumn(name = "order_Id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_Id")
    private Product product;
}
