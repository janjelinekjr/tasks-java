package task4_school;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Subject math = new Subject("Math");
        Subject physics = new Subject("Physics");
        Subject history = new Subject("History");

        Map<Subject, Grade> petersSubjects = new HashMap<>();
        petersSubjects.put(math, Grade.THREE);
        petersSubjects.put(physics, Grade.TWO);
        Student peter = new Student("Peter", petersSubjects);

        Map<Subject, Grade> johnsSubjects = new HashMap<>();
        johnsSubjects.put(math, Grade.ONE);
        johnsSubjects.put(physics, Grade.ONE);
        johnsSubjects.put(history, Grade.TWO);
        Student john = new Student("John", johnsSubjects);

        Map<Subject, Grade> alicesSubjects = new HashMap<>();
        alicesSubjects.put(math, Grade.FOUR);
        alicesSubjects.put(physics, Grade.THREE);
        alicesSubjects.put(history, Grade.ONE);
        Student alice = new Student("Alice", alicesSubjects);

        Map<Subject, Grade> jonathansSubjects = new HashMap<>();
        jonathansSubjects.put(math, Grade.FOUR);
        jonathansSubjects.put(physics, Grade.FIVE);
        jonathansSubjects.put(history, Grade.FIVE);
        Student jonathan = new Student("Jonathan", jonathansSubjects);

        Map<Subject, Grade> samuelsSubjects = new HashMap<>();
        samuelsSubjects.put(math, Grade.THREE);
        samuelsSubjects.put(physics, Grade.TWO);
        samuelsSubjects.put(history, Grade.ONE);
        Student samuel = new Student("Samuel", samuelsSubjects);

        Map<Subject, Grade> karelsSubjects = new HashMap<>();
        karelsSubjects.put(math, Grade.ONE);
        karelsSubjects.put(physics, Grade.ONE);
        karelsSubjects.put(history, Grade.ONE);
        Student karel = new Student("Karel", karelsSubjects);

        Teacher teacherJohn = new Teacher("John", List.of(math, physics));
        Teacher teacherLukas = new Teacher("Lucas", List.of(math, history));
        Teacher teacherMark = new Teacher("Mark", List.of(math, physics, history));

        Clazz secondB = new Clazz("2.B", List.of(john, peter), teacherJohn);
        Clazz firstC = new Clazz("1.C", List.of(alice, karel), teacherLukas);
        Clazz fourthA = new Clazz("4.A", List.of(jonathan, samuel), teacherMark);

        showSortedStudentsByAverageGrade(getAllStudents(List.of(secondB, firstC, fourthA)));
        System.out.println();
        System.out.println("---------------------------------------------");
        System.out.println();
        showSortedSubjectsByAverageGrade(getAllStudents(List.of(secondB, firstC, fourthA)));
        System.out.println();
        System.out.println("---------------------------------------------");
        System.out.println();
        showSortedClazzesByTheBestStudents(List.of(secondB, firstC, fourthA));
    }

    public static void showSortedStudentsByAverageGrade(List<Student> students) {
        System.out.println("Sorted students by their average grades: ");
        students.stream()
                .sorted(Comparator.comparing(Student::getAverageGrade))
                .forEach(s -> System.out.println(s.getName() + " - " + s.getAverageGrade()));
    }

    public static void showSortedSubjectsByAverageGrade(List<Student> students) {
        System.out.println("Sorted subjects by average of grades given to students: ");
        Map<Subject, Grade> allStudentsGradesInSubject = new HashMap<>();
        students.forEach(s -> allStudentsGradesInSubject.putAll(s.getSubjects()));
        Set<Subject> keys = allStudentsGradesInSubject.keySet();
    }

    public static void showSortedClazzesByTheBestStudents(List<Clazz> clazzes) {
        System.out.println("Sorted classes with the best students: ");
        clazzes.stream()
                .sorted(Comparator.comparing(Clazz::getAverageGrade))
                .forEach(c -> System.out.println(c.getName() + " - " + c.getAverageGrade()));
    }

    public static List<Student> getAllStudents(List<Clazz> clazzes) {
        return clazzes.stream()
                .flatMap(s -> s.getStudents().stream())
                .toList();
    }
}
