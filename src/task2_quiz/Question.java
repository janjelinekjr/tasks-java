package task2_quiz;

import java.util.ArrayList;
import java.util.List;

public class Question {
    private boolean enableMultiple;
    private String question;
    private List<Answer> answers;
    private int index;

    public Question(boolean enableMultiple, String question, int index) {
        this.enableMultiple = enableMultiple;
        this.question = question;
        this.index = index;
        this.answers = new ArrayList<>();
    }

    public void setAnswer(Answer answer) {
        answers.add(answer);
    }

    public void printQuestion() {
        System.out.println((index + 1) + ". " + this.question + " (Question with " + (this.enableMultiple ? "multiple" : "single") + " answer)");
        for (Answer answer : answers) {
            answer.printOption();
        }
    }

    public boolean checkAnswer(String option) {
        if (!this.enableMultiple) {
            Answer foundAnswer = null;
            for (Answer answer : this.answers) {
                if (answer.getPrefix() == option.charAt(0)) {
                    foundAnswer = answer;
                    break;
                }
            }

            assert foundAnswer != null;
            return foundAnswer.isAnswerCorrect();
        } else {
            List<Character> answerPrefixes = new ArrayList<>();
            boolean result = false;
            for (int i = 0; i < option.length(); i++) {
                answerPrefixes.add(option.charAt(i));
            }
            for (Answer answer : this.answers) {
                if (!answerPrefixes.contains(answer.getPrefix())) {
                    result = false;
                    break;
                } else {
                    result = true;
                }
            }

            return result;
        }
    }

    public boolean isMultiple() {
        return this.enableMultiple;
    }
}
