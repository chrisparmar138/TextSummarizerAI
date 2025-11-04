package com.summarizer;

import java.util.*;
import java.util.stream.Collectors;

public class Summarizer {

    private final SentenceScorer scorer;
    private final Preprocessor preprocessor;

    public Summarizer(SentenceScorer scorer) {
        this.scorer = scorer;
        this.preprocessor = new Preprocessor();
    }

    public String generateSummary(String text, double ratio) {
        List<String> sentences = preprocessor.preprocess(text);
        if (sentences.isEmpty()) return "No valid text found.";

        Map<String, Double> scores = scorer.scoreSentences(sentences);
        int summaryCount = Math.max(1, (int)(sentences.size() * ratio));

        List<String> topSentences = scores.entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .limit(summaryCount)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        return String.join(" ", topSentences);
    }
}
