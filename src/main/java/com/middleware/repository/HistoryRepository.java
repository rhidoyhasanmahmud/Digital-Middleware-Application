package com.middleware.repository;

import com.middleware.model.Courier;
import com.middleware.model.History;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryRepository  extends JpaRepository<History, Long> {
}
