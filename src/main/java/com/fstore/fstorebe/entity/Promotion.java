package com.fstore.fstorebe.entity;

import com.fstore.fstorebe.enums.PromotionType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "promotions", indexes = {
        @Index(name = "idx_promotions_code", columnList = "code", unique = true),
})
public class Promotion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String urlHandle;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Boolean status;

    @Enumerated(EnumType.STRING)
    private PromotionType type;

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

    @CreatedDate
    private Date createdAt;

    @LastModifiedDate
    private Date updatedAt;

    @OneToMany(mappedBy = "promotion", cascade = CascadeType.ALL)
    private List<Product> products = new ArrayList<>();
}
