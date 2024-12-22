package com.fstore.fstorebe.repository;

import com.fstore.fstorebe.entity.Color;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColorRepo extends JpaRepository<Color, Long> {
    Color findByName(String name);
    Color findByCode(String code);
}
