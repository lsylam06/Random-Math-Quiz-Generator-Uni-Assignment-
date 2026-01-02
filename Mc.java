import java.util.*;
import javax.swing.*;

public class Mc {
    public static void main(String[] args) {
        String[] questions = Questions.qMath;
        int[] answers = Questions.aMath;

        if (questions == null || answers == null || questions.length == 0 || answers.length == 0) {
            JOptionPane.showMessageDialog(null, "No math questions are available.");
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
            String prompt = questions[qIndex];

            String resp;
            while (true) {
                resp = JOptionPane.showInputDialog(null, "Question " + (ask + 1) + ":\n" + prompt);
                if (resp == null) {
                    JOptionPane.showMessageDialog(null, "Quiz cancelled. You scored " + correct + " out of " + (ask) + ".");
                    return;
                }
                resp = resp.trim();
                if (resp.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter a number answer.");
                    continue;
                }
                try {
                    int userAns = Integer.parseInt(resp);
                    int correctAns = answers[qIndex];
                    if (userAns == correctAns) {
                        correct++;
                    } else {
                    }
                    break;
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid integer answer.");
                }
            }
        }

        JOptionPane.showMessageDialog(null, "Quiz finished. You scored " + correct + " out of " + total + ".");
    }
}
