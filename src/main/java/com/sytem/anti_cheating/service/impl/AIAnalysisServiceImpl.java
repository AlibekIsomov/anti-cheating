package com.sytem.anti_cheating.service.impl;

import com.sytem.anti_cheating.service.AIAnalysisService;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class AIAnalysisServiceImpl implements AIAnalysisService {

    private final Pattern genericVariablePattern = Pattern.compile("\\b(var_\\d+|temp|data|output)\\b");

    public String analyzeCode(String code) {
        if (isAICommentStyle(code)) {
            return "Suspicious activity detected: Comments may be AI-generated.";
        }
        if (containsGenericPatterns(code)) {
            return "Suspicious activity detected: Possible AI-style variable naming.";
        }
        if (containsRedundantLogic(code)) {
            return "Suspicious activity detected: Code contains redundant logic typical of AI.";
        }
        return "Submission analyzed: No issues detected.";
    }

    private boolean isAICommentStyle(String code) {
        // Check if comments are unusually descriptive or verbose
        String[] lines = code.split("\n");
        for (String line : lines) {
            if (line.trim().startsWith("//") || line.trim().startsWith("/*")) {
                if (line.length() > 100) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean containsGenericPatterns(String code) {
//        To-Do
        return genericVariablePattern.matcher(code).find();
    }

    private boolean containsRedundantLogic(String code) {
        // To-Do
        return code.contains("if (true)") || code.contains("while (true)") || code.contains("return;");
    }
}

