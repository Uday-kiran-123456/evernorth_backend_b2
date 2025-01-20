package com.test.test.repository;

import com.test.test.model.UserPerformance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserPerformanceRepository extends JpaRepository<UserPerformance, Long> {
    List<UserPerformance> findByUserId(Long userId);
}
