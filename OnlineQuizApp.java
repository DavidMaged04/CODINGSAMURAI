import java.util.Scanner;

class Question {
    String questionText;
    String[] options;
    int correctAnswerIndex;

    public Question(String questionText, String[] options, int correctAnswerIndex) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswerIndex = correctAnswerIndex;
    }

    public boolean ask(Scanner scanner) {
        System.out.println("\n" + questionText);
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
        System.out.print("Your answer (1-" + options.length + "): ");
        int answer = scanner.nextInt();
        return answer == correctAnswerIndex + 1;
    }
}

public class OnlineQuizApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Question[] questions = {
            new Question("What is the capital of France?",
                    new String[]{"Berlin", "Paris", "Madrid", "Rome"}, 1),

            new Question("Who wrote 'Romeo and Juliet'?",
                    new String[]{"Charles Dickens", "William Shakespeare", "Leo Tolstoy", "Mark Twain"}, 1),

            new Question("What is the smallest prime number?",
                    new String[]{"1", "2", "3", "5"}, 1),

            new Question("Which planet is known as the Red Planet?",
                    new String[]{"Earth", "Jupiter", "Mars", "Venus"}, 2),

            new Question("Which language runs in a web browser?",
                    new String[]{"Java", "Python", "C", "JavaScript"}, 3)
        };

        int score = 0;

        System.out.println("Welcome to the Online Quiz!");

        for (Question q : questions) {
            if (q.ask(scanner)) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Wrong! The correct answer is: " + q.options[q.correctAnswerIndex]);
            }
        }

        System.out.println("\nQuiz Completed!");
        System.out.println("Your score: " + score + "/" + questions.length);
        scanner.close();
    }
}
