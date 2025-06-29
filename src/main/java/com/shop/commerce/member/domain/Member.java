package com.shop.commerce.member.domain;

import com.shop.commerce.entity.common.BaseEntity;
import com.shop.commerce.entity.common.Role;
import com.shop.commerce.member.presentation.dto.MemberUpdateRequest;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;


import java.util.Collection;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "MEMBER")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseEntity implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEMBER_UID")
    private Long memberUid;

    @Column(length = 30)
    private String id;

    @Column(length = 250)
    private String password;

    @Column(length = 100)
    private String name;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Builder
    private Member(String id, String password, String name, Role role) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.role = role;
    }

    public static Member createNewMember(String id, String password, String name){
        return Member.builder().id(id).password(password).name(name).role(Role.USER).build();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.getRoleName()));
    }

    @Override
    public String getUsername() {
        return id;
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }

    public void updateInfo(MemberUpdateRequest request, PasswordEncoder passwordEncoder) {
        validateCurrentPassword(passwordEncoder, request.getCurrentPassword());

        if (request.getName() != null) {
            this.name = request.getName();
        }
        if (request.getNewPassword() != null) {
            this.password = passwordEncoder.encode(request.getNewPassword());
        }
    }

    private void validateCurrentPassword(PasswordEncoder passwordEncoder, String currentPassword) {
        if (!passwordEncoder.matches(currentPassword, password)) {
            throw new IllegalArgumentException("Current password is incorrect");
        }
    }
}


