package com.shop.commerce.cart.dto;

import com.shop.commerce.entity.Cart;
import com.shop.commerce.entity.Member;
import com.shop.commerce.entity.Product;
import com.shop.commerce.product.dto.ProductDto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class CartRequest {
    @NotBlank(message = "ProductUid 는 필수 입력 값입니다.")
    private Long productUid;

    @Size(min = 1, message = "수량은 최소 1개 이상입니다.")
    private int quantity;

    public Cart toEntity(Member member, Product product) {
        return Cart.builder().member(member).product(product).quantity(this.quantity).build();
    }
}
