package com.shop.commerce.cart.service;

import com.shop.commerce.cart.repository.CartRepository;
import com.shop.commerce.entity.Cart;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {
    private final CartRepository cartRepository;

    public List<Cart> getAllCarts() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Long memberUid = Long.parseLong(authentication.getName());
        return cartRepository.findByMember_memberUid(memberUid);
    }
}
