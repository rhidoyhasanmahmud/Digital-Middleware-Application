package com.middleware.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "mw_history")
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long id;

    @Column(name = "action_name")
    public String actionName;

    @Column(name = "user_id")
    public Integer userId;

    @Column(name = "request_body")
    @Lob
    public String requestBody;

    @Column(name = "time")
    public Timestamp time;

    @Column(name = "ip_address")
    public String ipAddress;

    @PrePersist
    @PreUpdate
    private void preUpdate() {
        this.time = new Timestamp(System.currentTimeMillis());
    }

    @Override
    public String toString() {
        return "History{" +
                "id=" + id +
                ", actionName='" + actionName + '\'' +
                ", userId=" + userId +
                ", requestBody='" + requestBody + '\'' +
                ", time=" + time +
                '}';
    }
}
