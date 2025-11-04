package com.summarizer;

import java.util.*;

public class SentenceScorer {

    private final Preprocessor preprocessor = new Preprocessor();

    public Map<String, Double> scoreSentences(List<String> sentences) {
        Map<String, Double> sentenceScores = new HashMap<>();
        Map<String, Integer> wordFreq = new HashMap<>();

        for (String sentence : sentences) {
            String cleaned = preprocessor.removeStopwords(sentence);
            for (String word : cleaned.split("\\s+")) {
                if (!word.isBlank())
                    wordFreq.put(word, wordFreq.getOrDefault(word, 0) + 1);
            }
        }

        for (String sentence : sentences) {
            String cleaned = preprocessor.removeStopwords(sentence);
            double score = 0;
            for (String word : cleaned.split("\\s+")) {
                score += wordFreq.getOrDefault(word, 0);
            }
            sentenceScores.put(sentence, score);
        }

        return sentenceScores;
    }
}
