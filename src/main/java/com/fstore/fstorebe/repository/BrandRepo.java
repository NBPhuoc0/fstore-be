package com.fstore.fstorebe.repository;

import com.fstore.fstorebe.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepo extends JpaRepository<Brand, Long> {
    Brand findByName(String name);
}
