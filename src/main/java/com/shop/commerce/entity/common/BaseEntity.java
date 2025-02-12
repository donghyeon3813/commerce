package com.shop.commerce.entity.common;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import lombok.Getter;

import java.time.LocalDateTime;

@MappedSuperclass
@Getter
public class BaseEntity {
    @Column(name = "CREATE_DATE", nullable = true)
    private LocalDateTime createDate;

    @PrePersist
    protected void onCreate(){
        this.createDate = LocalDateTime.now();
    }
}
