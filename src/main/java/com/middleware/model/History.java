package com.middleware.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "mw_history")
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long id;

    @Column(name = "action_name")
    public String actionName;

    @Lob
    public String resultBody;

    public LocalDateTime logTime;

    @Column(name = "userName")
    public String userName;


    @PrePersist
    @PreUpdate
    private void preUpdate() {
        this.logTime = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "History{" +
                "id=" + id +
                ", actionName='" + actionName + '\'' +
                ", userName=" + userName +
                ", resultBody='" + resultBody + '\'' +
                ", logTime=" + logTime +
                '}';
    }
}
