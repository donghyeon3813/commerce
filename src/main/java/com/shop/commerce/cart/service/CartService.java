package com.shop.commerce.cart.service;

import com.shop.commerce.cart.dto.CartRequest;
import com.shop.commerce.cart.repository.CartRepository;
import com.shop.commerce.config.jwt.JwtUtil;
import com.shop.commerce.entity.Cart;
import com.shop.commerce.member.domain.Member;
import com.shop.commerce.entity.Product;
import com.shop.commerce.member.application.MemberService;
import com.shop.commerce.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {
    private final CartRepository cartRepository;
    private final MemberService memberService;
    private final ProductService productService;

    public List<Cart> getAllCarts() {

        Long memberUid = JwtUtil.getMemberUidFromToken();
        return cartRepository.findByMember_memberUid(memberUid);
    }

    public void createCart(CartRequest request) {
        Member member = memberService.getCurrentMember();
        Product product = productService.getProduct(request.getProductUid());
        cartRepository.save(request.toEntity(member, product));

    }
}
