package com.shop.commerce.member.presentation.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class MemberUpdateRequest {
    @Size(min = 2, max = 30, message = "이름은 2자 이상 30자 이하로 입력하세요.")
    private String name;
    @NotBlank(message = "현재 비밀번호를 입력하세요")
    private String currentPassword;
    @Size(min = 8, max = 16, message = "패스워드는 8자 이상 16자 이하입니다.")
    private String newPassword;
}
