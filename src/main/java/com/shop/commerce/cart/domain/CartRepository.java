package com.shop.commerce.cart.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Long> {
    List<Cart> findByMember_memberUid(Long memberUid);
}
