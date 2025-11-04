package com.summarizer;

import java.util.*;
import java.util.regex.*;

public class Preprocessor {

    private static final Set<String> STOPWORDS = new HashSet<>(Arrays.asList(
            "a","an","and","the","is","are","was","were","in","on","at","of","to","for",
            "with","that","this","it","as","by","from","or","be","if","then","so","but",
            "because","about","into","no","not","too","very","can","will","just"
    ));

    public String cleanText(String text) {
        if (text == null || text.isEmpty()) return "";
        text = text.toLowerCase();
        text = text.replaceAll("[^a-z0-9\\.\\!\\?\\s]", " ");
        text = text.replaceAll("\\s+", " ").trim();
        return text;
    }

    public List<String> splitIntoSentences(String text) {
        List<String> sentences = new ArrayList<>();
        Matcher matcher = Pattern.compile("[^.!?]+[.!?]?").matcher(text);
        while (matcher.find()) {
            String s = matcher.group().trim();
            if (!s.isEmpty()) sentences.add(s);
        }
        return sentences;
    }

    public String removeStopwords(String sentence) {
        StringBuilder sb = new StringBuilder();
        for (String w : sentence.split("\\s+")) {
            if (!STOPWORDS.contains(w)) sb.append(w).append(" ");
        }
        return sb.toString().trim();
    }

    public List<String> preprocess(String text) {
        return splitIntoSentences(cleanText(text));
    }
}
