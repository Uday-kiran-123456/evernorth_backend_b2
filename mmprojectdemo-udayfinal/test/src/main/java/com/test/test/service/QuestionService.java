package com.test.test.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class QuestionService {

    private Map<String, String> questionBank;

    public QuestionService() {
        // Initialize a sample question bank
        questionBank = new HashMap<>();
        questionBank.put("Java", "What are the key features of Java?");
        questionBank.put("Spring Boot", "Explain the advantages of using Spring Boot.");
        questionBank.put("MySQL", "Describe how you would optimize a MySQL database.");
    }

    public String generateQuestion(String skill) {
        // Generate a question based on the skill
        return questionBank.getOrDefault(skill, "Describe your experience with " + skill + ".");
    }
}
