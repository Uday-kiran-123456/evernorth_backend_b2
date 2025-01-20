package com.test.test.service;

import com.test.test.model.UserResponseAnalysis;
import org.springframework.stereotype.Service;

@Service
public class QuestionGenerationService {

    public String generateNextQuestion(UserResponseAnalysis analysis) {
        String nextQuestion;

        if (analysis.getProficiencyLevel().equals("high")) {
            nextQuestion = "Can you explain the differences between Java and JavaScript?";
        } else {
            nextQuestion = "What are the key features of Java?";
        }

        return nextQuestion;
    }
}
