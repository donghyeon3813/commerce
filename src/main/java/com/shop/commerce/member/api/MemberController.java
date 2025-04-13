package com.shop.commerce.member.api;

import com.shop.commerce.member.application.dto.MemberDto;
import com.shop.commerce.member.application.dto.MemberUpdateRequest;
import com.shop.commerce.member.application.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/member")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @PostMapping
    public ResponseEntity<String> create(@Valid @RequestBody MemberDto member) {
        memberService.createMember(member);
        return ResponseEntity.ok("Member created");
    }

    @PatchMapping
    public ResponseEntity<String> update(@Valid @RequestBody MemberUpdateRequest request) {
        memberService.updateMemberInfo(request);
        return ResponseEntity.ok("Member updated");
    }
}
