package com.shop.commerce.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "MEMBER")
public class Member extends BaseEntity {

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

    @Column(length = 5)
    private String role;

}


