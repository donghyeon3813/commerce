package com.shop.commerce.cart.service;

import com.shop.commerce.cart.dto.CartRequest;
import com.shop.commerce.cart.repository.CartRepository;
import com.shop.commerce.entity.Cart;
import com.shop.commerce.entity.Member;
import com.shop.commerce.entity.Product;
import com.shop.commerce.member.service.MemberService;
import com.shop.commerce.product.dto.ProductDto;
import com.shop.commerce.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CartService {
    private final CartRepository cartRepository;
    private final MemberService memberService;
    private final ProductService productService;

    public List<Cart> getAllCarts() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Long memberUid = Long.parseLong(authentication.getName());
        return cartRepository.findByMember_memberUid(memberUid);
    }

    public void createCart(CartRequest request) {
        Member member = memberService.getCurrentMember();
        Product product = productService.getProduct(request.getProductUid());
        cartRepository.save(request.toEntity(member, product));

    }
}
