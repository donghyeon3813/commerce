package com.shop.commerce.member.dto;

import com.shop.commerce.entity.Member;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Getter
public class MemberDto {
    @NotBlank(message = "ID는 필수 입력값입니다.")
    private String id;
    @NotBlank(message = "패스워드는 필수 입력값입니다.")
    @Size(min = 8, max = 16, message = "패스워드는 8자 이상 16자 이하입니다.")
    private String password;
    @NotBlank(message = "이름은 필수 입력값입니다.")
    private String name;

    public Member toEntity(PasswordEncoder passwordEncoder) {
        return Member.createNewMember(id, passwordEncoder.encode(password), name);
    }

    @Override
    public String toString() {
        return "MemberRequest(id=" + id + ", password=********, name=" + name + ")";
    }

}
