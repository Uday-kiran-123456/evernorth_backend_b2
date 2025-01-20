package com.test.test.service;

import com.test.test.model.Answer;
import com.test.test.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerService {

    @Autowired
    private AnswerRepository repository;

    @Autowired
    private ScoringService scoringService;

    public String evaluateAnswer(Answer answer) {
        // Save answer to the database
        repository.save(answer);

        // Evaluate answer
        return scoringService.scoreAnswer(answer.getAnswer());
    }
}
