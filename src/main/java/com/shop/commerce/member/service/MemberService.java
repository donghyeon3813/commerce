package com.shop.commerce.member.service;

import com.shop.commerce.entity.Member;
import com.shop.commerce.member.dto.MemberDto;
import com.shop.commerce.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService implements UserDetailsService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Member> member = memberRepository.findByName(username);
        return member.orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    public void createMember(MemberDto member) {
        memberRepository.save(member.toEntity(passwordEncoder));
    }
}
