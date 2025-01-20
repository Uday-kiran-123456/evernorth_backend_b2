package com.test.test.controller;


import com.test.test.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/interview-question")
public class QuestionController {

    @Autowired
    private QuestionService service;

    @GetMapping
    public String generateQuestion(@RequestParam String skill) {
        return service.generateQuestion(skill);
    }
}
