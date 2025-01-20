package com.test.test.service;

import com.test.test.model.UserPerformance;
import com.test.test.repository.UserPerformanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.OptionalDouble;

@Service
public class UserPerformanceService {
    @Autowired
    private UserPerformanceRepository repository;

    public UserPerformance saveUserPerformance(UserPerformance performance) {
        return repository.save(performance);
    }

    public List<UserPerformance> getUserPerformance(Long userId) {
        return repository.findByUserId(userId);
    }

    public OptionalDouble getAverageScore(Long userId) {
        List<UserPerformance> performances = repository.findByUserId(userId);
        return performances.stream().mapToInt(UserPerformance::getScore).average();
    }
}
