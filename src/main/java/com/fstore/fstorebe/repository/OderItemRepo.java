package com.fstore.fstorebe.repository;

import com.fstore.fstorebe.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OderItemRepo extends JpaRepository<OrderItem, Long> {}
