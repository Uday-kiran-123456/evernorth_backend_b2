package com.test.test.service;

import com.test.test.model.JobDescription;
import com.test.test.repository.JobDescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobDescriptionService {

    @Autowired
    private JobDescriptionRepository repository;

    @Autowired
    private NLPService nlpService;

    public String analyzeJobDescription(JobDescription jobDescription) {
        // Save job description to the database
        repository.save(jobDescription);

        // Analyze job description
        return nlpService.analyzeJobDescription(jobDescription);
    }

    public List<JobDescription> getAllJobDescriptions() {
        return repository.findAll();
    }
}
