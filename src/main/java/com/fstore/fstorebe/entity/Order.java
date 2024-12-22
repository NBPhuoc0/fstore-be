package com.fstore.fstorebe.entity;

import com.fstore.fstorebe.enums.OrderStatusType;
import com.fstore.fstorebe.enums.PaymentMethodType;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private OrderStatusType status;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PaymentMethodType paymentMethod;

    private String paymentRef;

    @Column(nullable = false)
    private Double shippingFee;

    @Column(nullable = false)
    private Double subTotal;

    @Column(nullable = false)
    private Double discount;

    @Column(nullable = false)
    private Double total;

    @CreatedDate
    private String createdAt;

    @LastModifiedDate
    private String updatedAt;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "voucher_id", nullable = true)
    private Voucher voucher;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> orderItems = new ArrayList<>();




}
