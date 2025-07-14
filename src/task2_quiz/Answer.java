package task2_quiz;

public class Answer {
    private boolean isCorrect;
    private int index;
    private String value;
    private char prefix;
    private char[] prefixes = {'a', 'b', 'c', 'd', 'e'};

    public Answer(boolean isCorrect, int index, String value) {
        this.index = index;
        this.value = value;
        this.isCorrect = isCorrect;
        this.prefix = prefixes[index];
    }

    public void printOption() {
        System.out.println(prefix + "." + " " + this.value);
    }

    public boolean isAnswerCorrect() {
        return this.isCorrect;
    }

    public char getPrefix() {
        return this.prefix;
    }
}
