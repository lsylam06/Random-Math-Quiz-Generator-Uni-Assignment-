/**
 * Name: Math.java
 * Programmer: Lam Sai Yuk Johnmar
 * Class: GSD1A
 * Details: This class handles the Mathematics quiz functionality for the Simple Quiz Generator program.
 * Date: 12/27/25
 */

import java.util.*;
import javax.swing.*;

public class Math {
    public static void main(String[] args) {
        String[] questions = Questions.qMc;
        String[] answers = Questions.aMc;

        if (questions == null || answers == null || questions.length == 0 || answers.length == 0) {
            JOptionPane.showMessageDialog(null, "No MC questions are available.");
            return;
        }

        int max = questions.length;
        int qNum = -1;
        while (true) {
            String input = JOptionPane.showInputDialog(null, "How many questions would you like to do? (1-" + max + ")");
            if (input == null || input.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "You must enter a number between 1 and " + max + ".");
                continue;
            }
            try {
                qNum = Integer.parseInt(input.trim());
                if (qNum < 1) {
                    JOptionPane.showMessageDialog(null, "Number must be at least 1.");
                    continue;
                }
                if (qNum > max) {
                    JOptionPane.showMessageDialog(null, "Maximum is " + max + ". Setting to " + max + ".");
                    qNum = max;
                }
                break;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter a valid number.");
            }
        }

        int total = java.lang.Math.min(qNum, questions.length);

        int correct = 0;

        List<Integer> order = new ArrayList<>();
        for (int k = 0; k < questions.length; k++) {
            order.add(k);
        }
        Collections.shuffle(order);

        for (int ask = 0; ask < total; ask++) {
            int qIndex = order.get(ask);
            String raw = questions[qIndex];
            String[] parts = raw.split("\\n");
            String prompt = parts[0].trim();

            List<String> opts = new ArrayList<>();
            for (int p = 1; p < parts.length; p++) {
                opts.add(parts[p].replaceFirst("^[A-Za-z]\\)\\s*", "").trim());
            }

            String origCorrectLabel = answers[qIndex].trim().toUpperCase();
            int origIndex = origCorrectLabel.charAt(0) - 'A';
            String origCorrectText = (origIndex >= 0 && origIndex < opts.size()) ? opts.get(origIndex) : "";

            List<String> shuffled = new ArrayList<>(opts);
            Collections.shuffle(shuffled);

            int newCorrectIndex = -1;
            for (int s = 0; s < shuffled.size(); s++) {
                if (shuffled.get(s).equals(origCorrectText)) {
                    newCorrectIndex = s;
                    break;
                }
            }

            StringBuilder qText = new StringBuilder();
            qText.append("Question ").append(ask + 1).append(":\n").append(prompt).append("\n");
            char lab = 'A';
            for (String o : shuffled) {
                qText.append(lab).append(") ").append(o).append("\n");
                lab++;
            }

            String resp;
            while (true) {
                resp = JOptionPane.showInputDialog(null, qText.toString());
                if (resp == null) {
                    JOptionPane.showMessageDialog(null, "Quiz cancelled. You scored " + correct + " out of " + (ask) + ".");
                    return;
                }
                resp = resp.trim().toUpperCase();
                if (resp.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter A-" + (char) ('A' + shuffled.size() - 1) + ".");
                    continue;
                }
                char ch = resp.charAt(0);
                if (ch < 'A' || ch >= 'A' + shuffled.size()) {
                    JOptionPane.showMessageDialog(null, "Please enter A-" + (char) ('A' + shuffled.size() - 1) + ".");
                    continue;
                }

                int picked = ch - 'A';
                if (picked == newCorrectIndex) {
                    correct++;
                } else {
                    char correctLetter = (char) ('A' + newCorrectIndex);
                    String correctText = (newCorrectIndex >= 0 ? shuffled.get(newCorrectIndex) : "");
                }
                break;
            }
        }

        JOptionPane.showMessageDialog(null, "Quiz finished. You scored " + correct + " out of " + total + ".");
    }
}