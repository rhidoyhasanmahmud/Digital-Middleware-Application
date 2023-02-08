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
    public Integer id;

    public String userName;

    public String name;

    public String email;

    public String password;

    public Integer isActive;

    public Integer totalDataPullCount;

    public Integer accountLocked;

    public LocalDateTime lastDataPull;

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
