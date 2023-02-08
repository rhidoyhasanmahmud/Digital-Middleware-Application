package com.middleware.model;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "mw_courier")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Courier{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer id;

    @Column(name = "rate")
    public Double rate;

    @Column(name = "name", unique = true)
    public String name;

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
