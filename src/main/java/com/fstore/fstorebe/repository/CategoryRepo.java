package com.fstore.fstorebe.repository;

import com.fstore.fstorebe.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepo extends JpaRepository<Category, Long> {
    Category findByUrlHandle(String urlHandle);

    List<Category> findByParent(Category parent);
}
