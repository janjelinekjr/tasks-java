package task4_school;

import java.util.List;
import java.util.Objects;

public class Clazz {
    private final String name;
    private List<Student> students;
    private final Teacher primaryTeacher;

    public Clazz(String name, List<Student> students, Teacher primaryTeacher) {
        this.name = name;
        this.students = students;
        this.primaryTeacher = primaryTeacher;
    }

    public Clazz(String name, Teacher primaryTeacher) {
        this.name = name;
        this.primaryTeacher = primaryTeacher;
    }

    public String getName() {
        return name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public Teacher getPrimaryTeacher() {
        return primaryTeacher;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public double getAverageGrade() {
        return students.stream()
                .mapToDouble(Student::getAverageGrade)
                .average()
                .orElse(0);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Clazz clazz = (Clazz) o;
        return Objects.equals(name, clazz.name) && Objects.equals(students, clazz.students) && Objects.equals(primaryTeacher, clazz.primaryTeacher);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, students, primaryTeacher);
    }
}
