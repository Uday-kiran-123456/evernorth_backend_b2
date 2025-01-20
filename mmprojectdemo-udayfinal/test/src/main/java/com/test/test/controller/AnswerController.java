package com.test.test.controller;

import com.test.test.model.Answer;
import com.test.test.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/answer")
public class AnswerController {

    @Autowired
    private AnswerService service;

    @PostMapping
    public String evaluateAnswer(@RequestBody Answer answer) {
        return service.evaluateAnswer(answer);
    }
}
