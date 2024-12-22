package com.fstore.fstorebe.repository;

import com.fstore.fstorebe.entity.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product, Long> {
    Page<Product> findByCategory(Category category, Color color, Size size, Brand brand, Pageable pageable);

    Product findByCode(String code);

    Product findByUrlHandle(String urlHandle);
}
