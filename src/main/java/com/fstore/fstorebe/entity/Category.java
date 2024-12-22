package com.fstore.fstorebe.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "categories", uniqueConstraints = {
        @UniqueConstraint(name = "category_url_handle_unique", columnNames = "urlHandle")
})
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(nullable = false)
    private String urlHandle;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Product> products = new ArrayList<>();

    @Setter
    @Getter
    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Category parent;

    @Getter
    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Category> children = new ArrayList<>();


    public Category(String name, String urlHandle) {
        this.name = name;
        this.urlHandle = urlHandle;
    }

    public Category(String name, String urlHandle, Category parent) {
        this.name = name;
        this.urlHandle = urlHandle;
        this.parent = parent;
    }

    public void addChild(Category child) {
        this.children.add(child);
        child.setParent(this);
    }

    public void removeChild(Category child) {
        this.children.remove(child);
        child.setParent(null);
    }
}
