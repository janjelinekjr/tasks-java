package task4_school;

import java.util.List;
import java.util.Objects;

public class Teacher {
    private final String name;
    private List<Subject> subjects;

    public Teacher(String name, List<Subject> subjects) {
        this.name = name;
        this.subjects = subjects;
    }

    public Teacher(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return Objects.equals(name, teacher.name) && Objects.equals(subjects, teacher.subjects);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, subjects);
    }
}
