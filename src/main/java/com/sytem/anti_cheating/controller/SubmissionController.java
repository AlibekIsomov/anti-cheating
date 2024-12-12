package com.sytem.anti_cheating.controller;

import com.sytem.anti_cheating.service.SubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/submissions")
public class SubmissionController {
    @Autowired
    private SubmissionService submissionService;

    @PostMapping
    public String submitCode(@RequestParam String username, @RequestParam String code) {
        return submissionService.handleSubmission(username, code);
    }
}
