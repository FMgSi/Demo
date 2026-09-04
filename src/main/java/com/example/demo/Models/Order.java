package com.example.demo.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "order")
@Getter
@Setter
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_Id", nullable = false)
    private int OrderId;

    private LocalDateTime OderDate;
    private BigDecimal TotalAmount;
    private String ShippingAddress;
    private String PhoneNumber;
    private String PaymentMethod;
    private String PaymentStatus;
    private String OrderStatus;

    @ManyToOne
    @JoinColumn(name = "user_Id")
    private User user;

    @OneToMany(mappedBy = "order")
    private List<OrderDetail> orderDetails = new ArrayList<>();

}
