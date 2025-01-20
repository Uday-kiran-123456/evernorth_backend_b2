package com.test.test.service;

import com.test.test.model.Answer;
import com.test.test.model.UserPerformance;
import com.test.test.repository.UserPerformanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.OptionalDouble;

@Service
public class ScoringService {
    @Autowired
    private UserPerformanceRepository performanceRepository;

    public String scoreAnswer(String answer) {
        int score;
        if (answer.toLowerCase().contains("java") && answer.toLowerCase().contains("spring boot")) {
            score = 10;
        } else if (answer.toLowerCase().contains("java")) {
            score = 7;
        } else if (answer.toLowerCase().contains("spring boot")) {
            score = 5;
        } else {
            score = 3;
        }
        String feedback = (score > 5) ? "Good answer!" : "Needs improvement.";
        saveUserPerformance(1L, "Java", score); // Placeholder userId and skill
        return feedback + " Your score is: " + score;
    }

    private void saveUserPerformance(Long userId, String skill, int score) {
        UserPerformance performance = new UserPerformance();
        performance.setUserId(userId);
        performance.setSkill(skill);
        performance.setScore(score);
        performanceRepository.save(performance);
    }
}
