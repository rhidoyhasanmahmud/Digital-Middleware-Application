package com.middleware.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "mw_user")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer id;

    @Column(name = "name")
    public String name;

    @Column(name = "email")
    public String email;

    @Column(name = "password")
    public String password;

    @Column(name = "is_active")
    public Integer isActive;

    @Column(name = "password_try_count")
    public Integer passwordTryCount;

    @Column(name = "account_locked")
    public Integer accountLocked;

    @Setter(value = AccessLevel.PRIVATE)
    public LocalDateTime updatedAt;

    @Column(updatable = false)
    public LocalDateTime createdAt;

    @PrePersist
    void onInsert() {
        createdAt = LocalDateTime.now();
    }

    @PreUpdate
    void onUpdate() {
        updatedAt = LocalDateTime.now();
    }


}
