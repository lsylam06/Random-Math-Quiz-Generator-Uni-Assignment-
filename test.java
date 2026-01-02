import javax.swing.*;

public class test {
    public static void main(String[] args) {
        String[] additionQuestions = generateAdditionProblems();
        String[] subtractionQuestions = generateSubtractionProblems();
        String[] multiplicationQuestions = generateMultiplicationProblems();
        String[] divisionQuestions = generateDivisionProblems();
        
        runQuiz(additionQuestions, "Addition Quiz");
    }
    
    public static String[] generateAdditionProblems() {
        return new String[] {
            "1. 15 + 28 = ? (Answer: 43)",
            "2. 42 + 19 = ? (Answer: 61)",
            "3. 37 + 13 = ? (Answer: 50)",
            "4. 8 + 45 = ? (Answer: 53)",
            "5. 50 + 0 = ? (Answer: 50)",
            "6. 23 + 27 = ? (Answer: 50)",
            "7. 31 + 19 = ? (Answer: 50)",
            "8. 14 + 36 = ? (Answer: 50)",
            "9. 6 + 44 = ? (Answer: 50)",
            "10. 25 + 25 = ? (Answer: 50)"
        };
    }
    
    public static String[] generateSubtractionProblems() {
        return new String[] {
            "1. 85 - 47 = ? (Answer: 38)",
            "2. 100 - 63 = ? (Answer: 37)",
            "3. 72 - 29 = ? (Answer: 43)",
            "4. 50 - 25 = ? (Answer: 25)",
            "5. 99 - 1 = ? (Answer: 98)",
            "6. 45 - 18 = ? (Answer: 27)",
            "7. 88 - 42 = ? (Answer: 46)",
            "8. 67 - 34 = ? (Answer: 33)",
            "9. 91 - 56 = ? (Answer: 35)",
            "10. 75 - 30 = ? (Answer: 45)"
        };
    }
    
    public static String[] generateMultiplicationProblems() {
        return new String[] {
            "1. 7 × 8 = ? (Answer: 56)",
            "2. 9 × 4 = ? (Answer: 36)",
            "3. 6 × 6 = ? (Answer: 36)",
            "4. 10 × 3 = ? (Answer: 30)",
            "5. 5 × 9 = ? (Answer: 45)",
            "6. 8 × 2 = ? (Answer: 16)",
            "7. 4 × 7 = ? (Answer: 28)",
            "8. 3 × 10 = ? (Answer: 30)",
            "9. 1 × 9 = ? (Answer: 9)",
            "10. 0 × 5 = ? (Answer: 0)"
        };
    }
    
    public static String[] generateDivisionProblems() {
        return new String[] {
            "1. 48 ÷ 6 = ? (Answer: 8)",
            "2. 81 ÷ 9 = ? (Answer: 9)",
            "3. 64 ÷ 8 = ? (Answer: 8)",
            "4. 100 ÷ 25 = ? (Answer: 4)",
            "5. 72 ÷ 12 = ? (Answer: 6)",
            "6. 36 ÷ 4 = ? (Answer: 9)",
            "7. 50 ÷ 10 = ? (Answer: 5)",
            "8. 45 ÷ 9 = ? (Answer: 5)",
            "9. 56 ÷ 7 = ? (Answer: 8)",
            "10. 84 ÷ 14 = ? (Answer: 6)"
        };
    }
    
    public static void runQuiz(String[] questions, String title) {
        int score = 0;
        
        for (String question : questions) {
            String answer = JOptionPane.showInputDialog(null, 
                question, 
                title, 
                JOptionPane.QUESTION_MESSAGE);
            
            if (answer != null) {
                JOptionPane.showMessageDialog(null, 
                    "You answered: " + answer + "\n" + 
                    "Question: " + question);
            }
        }
        
        JOptionPane.showMessageDialog(null, 
            "Quiz completed!\n" +
            "Questions: " + questions.length);
    }
}