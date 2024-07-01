package com.shop.commerce.member;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "MEMBER")
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
public class Member {
    @Id
    @Column(name = "MEMBER_UID")
    private Long memberUid;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "password")
    private String password;

    public void setPassword(String password) {

        this.password = password;
    }
}
