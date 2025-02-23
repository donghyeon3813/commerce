package com.shop.commerce.member.repository;

import com.shop.commerce.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findById(String id);
    Optional<Member> findByMemberUid(Long memberUid);

    boolean existsById(String id);
}
