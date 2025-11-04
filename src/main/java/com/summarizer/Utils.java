package com.summarizer;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Utils {

    public static String readFile(String path) {
        try {
            return String.join(" ", Files.readAllLines(Paths.get(path)));
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return "";
        }
    }

    public static void saveSummaryToFile(String summary, String output) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(output))) {
            bw.write(summary);
            System.out.println("Summary saved to: " + output);
        } catch (IOException e) {
            System.out.println("Error saving summary: " + e.getMessage());
        }
    }

    public static double safeRatio(double ratio) {
        if (ratio < 0.1) return 0.1;
        if (ratio > 0.9) return 0.9;
        return ratio;
    }

    public static void printDivider() {
        System.out.println("--------------------------------------------------");
    }
}
