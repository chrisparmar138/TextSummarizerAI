package com.summarizer;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Summarizer summarizer = new Summarizer(new SentenceScorer());

        Utils.printDivider();
        System.out.println("Welcome to Text Summarizer AI (Java Edition)");
        Utils.printDivider();

        System.out.print("Would you like to input text manually or from a file? (text/file): ");
        String mode = sc.nextLine().trim();

        String input = "";
        if (mode.equalsIgnoreCase("file")) {
            System.out.print("Enter file path: ");
            input = Utils.readFile(sc.nextLine().trim());
        } else {
            System.out.println("Enter your text (press Enter twice to finish):");
            StringBuilder sb = new StringBuilder();
            while (true) {
                String line = sc.nextLine();
                if (line.isEmpty()) break;
                sb.append(line).append(" ");
            }
            input = sb.toString();
        }

        System.out.print("Enter summary ratio (0.1–0.9): ");
        double ratio;
        try {
            ratio = Double.parseDouble(sc.nextLine());
        } catch (NumberFormatException e) {
            ratio = 0.3;
        }
        ratio = Utils.safeRatio(ratio);

        Utils.printDivider();
        System.out.println("Generating summary...");
        Utils.printDivider();

        String summary = summarizer.generateSummary(input, ratio);
        System.out.println("Summary:\n" + summary);

        System.out.print("\nSave summary to file? (y/n): ");
        if (sc.nextLine().trim().equalsIgnoreCase("y")) {
            Utils.saveSummaryToFile(summary, "summary_output.txt");
        }

        System.out.println("Done! Thank you for using Text Summarizer AI.");
        Utils.printDivider();
        sc.close();
    }
}
