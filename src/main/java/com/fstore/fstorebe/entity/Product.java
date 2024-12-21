package com.fstore.fstorebe.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "product", indexes = {
        @Index(name = "idx_unique_code", columnList = "code", unique = true),
        @Index(name = "idx_unique_url_handle", columnList = "urlHandle", unique = true)
})
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String code;

    @Column(nullable = false)
    private String urlHandle;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String metaDesc;

    private Boolean display = true;

    private Boolean inventoryStatus = true;

    @Column(nullable = false)
    private Double originalPrice;

    private Double salePrice = null;

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime updatedDate;

    @ManyToOne
    @JoinColumn(name = "promotion_id")
    private Promotion promotion;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @ManyToOne
    @JoinColumn(name = "brand_id", nullable = false)
    private Brand brand;

    @ManyToMany
    @JoinTable(
            name = "product_size", // Tên bảng trung gian
            joinColumns = @JoinColumn(name = "product_id"), // Khóa ngoại tới Product
            inverseJoinColumns = @JoinColumn(name = "size_id") // Khóa ngoại tới Size
    )
    private List<Size> sizes = new ArrayList<>();

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductColor> colors = new ArrayList<>();

//  todo: add collection later
//    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Collection> collections = new ArrayList<>();

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Variant> variants = new ArrayList<>();

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Image> images = new ArrayList<>();


    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
        if (promotion == null) {
            this.salePrice = null;
            return;
        }
        switch (promotion.getType()) {
            case PERCENTAGE:
                double discount = this.originalPrice * promotion.getValue() / 100;
                this.salePrice = this.originalPrice - (
                        discount > promotion.getMaxDiscount() ? promotion.getMaxDiscount():discount
                );
                break;
            case FIXED_AMOUNT:
                this.salePrice = promotion.getValue();
                break;
            case NET_AMOUNT:
                this.salePrice = this.originalPrice - promotion.getValue();
                break;
        }
    }

}
