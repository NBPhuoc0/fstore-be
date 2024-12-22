package com.fstore.fstorebe.entity;

import jakarta.persistence.*;
import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "variants")
public class Variant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer inventoryQuantity;

    @ManyToOne
    @JoinColumn(name = "color_id", nullable = false)
    private Color color;

    @ManyToOne
    @JoinColumn(name = "size_id", nullable = false)
    private Size size;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
}
