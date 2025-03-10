package com.shop.commerce.cart.repository;

import com.shop.commerce.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Long> {
    List<Cart> findByMember_memberUid(Long memberUid);
}
