package com.fstore.fstorebe.repository;

import com.fstore.fstorebe.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order, Long> {

}
