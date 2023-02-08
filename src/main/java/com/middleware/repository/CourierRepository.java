package com.middleware.repository;

import com.middleware.model.Courier;
import com.middleware.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourierRepository extends JpaRepository<Courier, Long> {
    List<Courier> getAllByIsActive(Boolean isActive);
}
