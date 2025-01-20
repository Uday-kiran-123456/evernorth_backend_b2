package com.test.test.controller;

import com.test.test.service.PythonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/interview")
public class InterviewController {

    @Autowired
    private PythonService pythonService;

    @PostMapping("/generate-questions")
    public String generateQuestions(@RequestBody Map<String, String> request) {
        String category = request.get("category");
        String level = request.get("level");

        if (category == null || level == null) {
            throw new IllegalArgumentException("Category and level are required fields.");
        }

        return pythonService.runPythonScript(category, level);
    }
}
