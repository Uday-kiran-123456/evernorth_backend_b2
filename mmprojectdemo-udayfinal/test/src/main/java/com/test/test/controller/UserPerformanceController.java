package com.test.test.controller;

import com.test.test.model.UserPerformance;
import com.test.test.service.UserPerformanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user-performance")
public class UserPerformanceController {

    @Autowired
    private UserPerformanceService service;

    @PostMapping
    public UserPerformance addUserPerformance(@RequestBody UserPerformance performance) {
        return service.saveUserPerformance(performance);
    }

    @GetMapping("/{userId}")
    public List<UserPerformance> getUserPerformance(@PathVariable Long userId) {
        return service.getUserPerformance(userId);
    }

    @GetMapping("/average/{userId}")
    public double getAverageScore(@PathVariable Long userId) {
        return service.getAverageScore(userId).orElse(0.0);
    }
}
