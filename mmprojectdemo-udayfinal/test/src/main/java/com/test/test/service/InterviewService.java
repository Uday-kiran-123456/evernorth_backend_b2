package com.test.test.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class InterviewService {

    public Map<String, String> getNextQuestionAndFeedback(String answer) {
        Map<String, String> response = new HashMap<>();
        String feedback;
        String nextQuestion;

        // Evaluate the answer and determine feedback and next question
        if (answer.toLowerCase().contains("java")) {
            feedback = "Good understanding of Java!";
            nextQuestion = "Can you explain the differences between Java and JavaScript?";
        } else {
            feedback = "Interesting answer. Let's dive deeper.";
            nextQuestion = "What are the key features of Java?";
        }

        response.put("feedback", feedback);
        response.put("nextQuestion", nextQuestion);
        return response;
    }
}
