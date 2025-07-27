package task4_school;

import java.util.Map;

public class Student {
    private String name;
    private Map<Subject, Grade> subjects;

    public Student(String name) {
        this.name = name;
    }

    public Student(String name, Map<Subject, Grade> subjects) {
        this.name = name;
        this.subjects = subjects;
    }

    public String getName() {
        return name;
    }

    public Map<Subject, Grade> getSubjects() {
        return subjects;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSubjects(Map<Subject, Grade> subjects) {
        this.subjects = subjects;
    }

    public double getAverageGrade() {
        return subjects.values().stream()
                .mapToDouble(Grade::getValue)
                .average()
                .orElse(0);
    }
}
