package com.fstore.fstorebe.entity;

import com.fstore.fstorebe.enums.VoucherType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@Getter
@Setter
@Entity
public class Voucher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String code;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    private Boolean status = true;

    @Enumerated(EnumType.STRING)
    private VoucherType type;

    @Column(nullable = false)
    private Double value;

    @Column(nullable = false)
    private Double maxDiscount;

    @Column(nullable = false)
    private String image;

    @Column(nullable = false)
    private Date startDate;

    @Column(nullable = false)
    private Date endDate;

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false)
    private Integer usedQuantity;

    @CreatedDate
    private Date createdAt;

    @LastModifiedDate
    private Date updatedAt;
}
