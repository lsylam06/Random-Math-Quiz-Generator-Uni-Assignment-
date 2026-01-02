/**
 * Program Name: Start.java
 * Details: The start of the Simple Quiz Generator, this code loads a set of questions in which the player will have to choose between Mathimatics of MC quiz.
 * Date: 12/27/25
 */

import java.util.*;
import javax.swing.*;

public class Start {
    public static void main (String[] args) {
        String[] options = {"Math", "MC"};
        while (true) {
            int choice = JOptionPane.showOptionDialog(
                null,
                "Simple Quiz Generator\nChoose a quiz to do.",
                "Choose Quiz",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
            );

            if (choice == JOptionPane.CLOSED_OPTION) {
                break;
            }

            if (choice == 0) {
                Math.main(args);
            } else if (choice == 1) {
                Mc.main(args);
            }

            int again = JOptionPane.showConfirmDialog(null, "Do you want to choose another quiz?", "Play again?", JOptionPane.YES_NO_OPTION);
            if (again != JOptionPane.YES_OPTION) {
                break;
            }
        }
    }
}