package task4_school;

import java.util.List;

public abstract class Student {
    private String name;
    private List<Subject> subjects;

    public Student(String name) {
        this.name = name;
    }

    public Student(String name, List<Subject> subjects) {
        this.name = name;
        this.subjects = subjects;
    }

    public String getName() {
        return name;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }
}
