package task4_school;

public abstract class Subject {
    private String name;
    private int grade;

    public Subject(String name) {
        this.name = name;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

}
