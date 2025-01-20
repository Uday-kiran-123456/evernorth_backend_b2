package com.test.test.controller;

import com.test.test.model.JobDescription;
import com.test.test.service.JobDescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/job-description")
public class JobDescriptionController {

    @Autowired
    private JobDescriptionService service;

    @PostMapping
    public String addJobDescription(@RequestBody JobDescription jobDescription) {
        return service.analyzeJobDescription(jobDescription);
    }

    @GetMapping
    public List<JobDescription> getAllJobDescriptions() {
        return service.getAllJobDescriptions();
    }
}
