package com.fstore.fstorebe.repository;

import com.fstore.fstorebe.entity.Cart;
import com.fstore.fstorebe.entity.CartItem;
import com.fstore.fstorebe.entity.Variant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartItemRepo extends JpaRepository<CartItem, Long> {
    List<CartItem> findByCart(Cart cart);
    CartItem findByCartAndVariant(Cart cart, Variant variant);
    void deleteByCart(Cart cart);
    void deleteByCartAndVariant(Cart cart, Variant variant);
}
