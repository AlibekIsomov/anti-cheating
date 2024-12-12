package com.sytem.anti_cheating.service.impl;

import com.sytem.anti_cheating.entity.Submission;
import com.sytem.anti_cheating.repository.SubmissionRepository;
import com.sytem.anti_cheating.service.AIAnalysisService;
import com.sytem.anti_cheating.service.SubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class SubmissionServiceImpl implements SubmissionService {
    @Autowired
    private SubmissionRepository submissionRepository;

    @Autowired
    private AIAnalysisService aiAnalysisService;

    @Override
    public String handleSubmission(String username, String code) {
        Submission submission = new Submission();
        submission.setUsername(username);
        submission.setCode(code);
        submission.setTimestamp(LocalDateTime.now());

        String analysisResult = aiAnalysisService.analyzeCode(code);

        submissionRepository.save(submission);
        return analysisResult;
    }
}
