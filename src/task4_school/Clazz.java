package task4_school;

import java.util.List;

public abstract class Clazz {
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
}
