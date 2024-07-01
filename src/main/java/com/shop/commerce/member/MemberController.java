package com.shop.commerce.member;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;


    @GetMapping("/create")
    public Member create(){
        Member member = new Member(1L,"email", "password");
        return memberService.save(member);
    }
}
