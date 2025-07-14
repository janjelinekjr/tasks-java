package task2_quiz;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int questionIndex = 0;
        int correctAnswers = 0;

        Question question1 = new Question(false, "What is 2 + 2?", 0);
        Answer answer1_1 = new Answer(false, 0, "5");
        Answer answer1_2 = new Answer(true, 1, "4");
        Answer answer1_3 = new Answer(false, 2, "2");
        question1.setAnswer(answer1_1);
        question1.setAnswer(answer1_2);
        question1.setAnswer(answer1_3);

        Question question2 = new Question(false, "What is 2 + 5?", 1);
        Answer answer2_1 = new Answer(true, 0, "7");
        Answer answer2_2 = new Answer(false, 1, "4");
        Answer answer2_3 = new Answer(false, 2, "9");
        question2.setAnswer(answer2_1);
        question2.setAnswer(answer2_2);
        question2.setAnswer(answer2_3);

        Question question3 = new Question(true, "4 = ?", 2);
        Answer answer3_1 = new Answer(true, 0, "2^2");
        Answer answer3_2 = new Answer(true, 1, "-2^2");
        Answer answer3_3 = new Answer(true, 2, "1 + 3");
        Answer answer3_4 = new Answer(true, 3, "4^1");
        question3.setAnswer(answer3_1);
        question3.setAnswer(answer3_2);
        question3.setAnswer(answer3_3);
        question3.setAnswer(answer3_4);

        Quiz quiz = new Quiz("Math Quiz");
        quiz.setQuestion(question1);
        quiz.setQuestion(question2);
        quiz.setQuestion(question3);

        System.out.println("Welcome to quiz " + quiz.getName());
        System.out.println("This quiz has " + quiz.getTotalQuestionsCount() + " questions.");

        while (questionIndex < quiz.getTotalQuestionsCount()) {
            Question currQuestion = quiz.getQuestion(questionIndex);
            currQuestion.printQuestion();
            try {
                String userInput = scanner.nextLine();

                if (!currQuestion.isMultiple() && userInput.length() > 1) {
                    throw new InputMismatchException("Select only one option");
                }

                try {
                    if (currQuestion.checkAnswer(userInput)) {
                        correctAnswers++;
                    }
                    questionIndex++;
                } catch (Exception e) {
                    System.out.println("Invalid input");
                }
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("You had " + correctAnswers + "/" + quiz.getTotalQuestionsCount() + " answers correct");
    }
}
