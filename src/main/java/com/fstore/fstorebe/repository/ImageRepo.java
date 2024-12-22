package com.fstore.fstorebe.repository;

import com.fstore.fstorebe.entity.Image;
import com.fstore.fstorebe.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageRepo extends JpaRepository<Image, Long> {
    List<Image> findByProduct(Product product);
    void deleteByProduct(Product product);
}
