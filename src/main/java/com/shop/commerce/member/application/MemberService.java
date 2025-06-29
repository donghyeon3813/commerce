package com.shop.commerce.member.application;

import com.shop.commerce.config.jwt.JwtUtil;
import com.shop.commerce.member.domain.Member;
import com.shop.commerce.member.presentation.dto.MemberDto;
import com.shop.commerce.member.presentation.dto.MemberUpdateRequest;
import com.shop.commerce.member.domain.MemberJpaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberService implements UserDetailsService {
    private final MemberJpaRepository memberRepository;
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
    @Transactional
    public void updateMemberInfo(MemberUpdateRequest request) {
        Long memberUid = JwtUtil.getMemberUidFromToken();

        Member member = memberRepository.findByMemberUid(memberUid)
                .orElseThrow(() -> new IllegalArgumentException("Member not found"));

        member.updateInfo(request, passwordEncoder);
    }

    public Member getCurrentMember() {
        Long memberUid = JwtUtil.getMemberUidFromToken();

        return memberRepository.findByMemberUid(memberUid)
                .orElseThrow(() -> new IllegalArgumentException("Member not found"));
    }

}
