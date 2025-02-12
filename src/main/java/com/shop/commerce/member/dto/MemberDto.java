package com.shop.commerce.member.dto;

import com.shop.commerce.entity.Member;
import lombok.Getter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Getter
public class MemberDto {
    private String id;
    private String password;
    private String name;

    public Member toEntity(PasswordEncoder passwordEncoder) {
        return Member.createNewMember(id, passwordEncoder.encode(password), name);
    }

}
