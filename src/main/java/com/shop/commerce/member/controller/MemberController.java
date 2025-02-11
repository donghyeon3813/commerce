package com.shop.commerce.member.controller;

import com.shop.commerce.member.dto.MemberDto;
import com.shop.commerce.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @PostMapping
    public String create(@RequestBody MemberDto member) {
        memberService.createMember(member);
        return "";
    }
}
