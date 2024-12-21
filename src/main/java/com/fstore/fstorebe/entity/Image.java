package com.fstore.fstorebe.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //todo: after add s3
//    @Column(nullable = false)
    private String url;

    @Column(nullable = false)
    private Integer position;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product; // Xác định ảnh thuộc sản phẩm nào

    @ManyToOne
    @JoinColumn(name = "color_id", nullable = true)
    private Color color; // Xác định ảnh thuộc màu sắc nào (nếu có)

    // Getters và Setters
}
