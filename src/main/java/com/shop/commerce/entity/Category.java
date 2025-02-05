package com.shop.commerce.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "CATEGORY")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CATEGORY_UID")
    private Long categoryUid;

    @Column(name = "CATEGORY_NAME", nullable = false, length = 30)
    private String categoryName;
}

