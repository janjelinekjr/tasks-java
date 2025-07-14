package task2_quiz;

import java.util.ArrayList;
import java.util.List;

public class Quiz {
    private String name;
    private List<Question> questions;

    public Quiz(String name) {
        this.name = name;
        this.questions = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public void setQuestion(Question question) {
        questions.add(question);
    }

    public int getTotalQuestionsCount() {
        return questions.size();
    }

    public Question getQuestion(int index) {
        return this.questions.get(index);
    }
}
