package com.shop.commerce.member.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberJpaRepository extends JpaRepository<Member, Long> {
    Optional<Member> findById(String id);
    Optional<Member> findByMemberUid(Long memberUid);

    boolean existsById(String id);
}
