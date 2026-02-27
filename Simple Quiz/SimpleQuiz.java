import java.util.Scanner;
import java.util.Arrays;

class SimpleQuiz {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Questions
        String[] questions = {
            "1. Which language is used for Android Development?",
            "2. Which keyword is used to create object in Java?",
            "3. Which method is entry point of Java program?"
        };

        // Options
        String[][] options = {
            {"A. Python", "B. Java", "C. C++", "D. PHP"},
            {"A. new", "B. class", "C. void", "D. static"},
            {"A. start()", "B. run()", "C. main()", "D. init()"}
        };

        // Correct answers
        String[] answers = {"B", "A", "C"};

        int score = 0;

        System.out.println("===== SIMPLE QUIZ APPLICATION =====");

        for (int i = 0; i < questions.length; i++) {

            System.out.println("\n" + questions[i].toUpperCase());  

            for (String opt : options[i]) {
                System.out.println(opt);
            }

            System.out.print("Enter your answer (A/B/C/D): ");
            String userAnswer = sc.nextLine().trim().toUpperCase();  

            // Check using equals method
            if (userAnswer.equals(answers[i])) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Wrong! Correct Answer is: " + answers[i]);
            }
        }

        System.out.println("\n===== QUIZ FINISHED =====");
        System.out.println("Total Questions: " + Integer.valueOf(questions.length));  
        System.out.println("Your Score: " + score);

        // Percentage calculation
        int percentage = Integer.parseInt(String.valueOf(score * 100 / questions.length));
        System.out.println("Percentage: " + percentage + "%");

        System.out.println("Thank You for Playing!");
        System.exit(0);   
    }
}