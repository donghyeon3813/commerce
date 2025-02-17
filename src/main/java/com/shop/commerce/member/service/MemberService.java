package com.shop.commerce.member.service;

import com.shop.commerce.entity.Member;
import com.shop.commerce.member.dto.MemberDto;
import com.shop.commerce.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberService implements UserDetailsService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        Optional<Member> member = memberRepository.findById(id);
        return member.orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    public void createMember(MemberDto member) {
        log.info("Creating member : {}", member);
        try {
            if (memberRepository.existsById(member.getId())) {
                throw new IllegalArgumentException("Member already exists");
            }
            memberRepository.save(member.toEntity(passwordEncoder));
        }catch (Exception e){
            throw new RuntimeException("Failed to save member");
        }

    }
}
