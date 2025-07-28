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

        showResult(List.of(secondB, firstC, fourthA));
    }

    public static void showResult(List<Clazz> clazzes) {
        showSortedStudentsByAverageGrade(getAllStudents(clazzes));
        System.out.println();
        System.out.println("---------------------------------------------");
        System.out.println();
        showSortedSubjectsByAverageGrade(getAllStudents(clazzes));
        System.out.println();
        System.out.println("---------------------------------------------");
        System.out.println();
        showSortedClazzesByTheBestStudents(clazzes);
    }

    public static void showSortedStudentsByAverageGrade(List<Student> students) {
        System.out.println("Sorted students by their average grades: ");
        students.stream()
                .sorted(Comparator.comparing(Student::getAverageGrade))
                .forEach(s -> System.out.println(s.getName() + " - " + s.getAverageGrade()));
    }

    public static void showSortedSubjectsByAverageGrade(List<Student> students) {
        System.out.println("Sorted subjects by average of grades given to students: ");
        Map<Subject, List<Grade>> gradesBySubject = new HashMap<>();
        Map<String, Double> sortedSubjectsByGrades = new HashMap<>();
        students.stream()
                .flatMap(s -> s.getSubjects().entrySet().stream())
                .forEach(entry -> {
                    gradesBySubject
                            .computeIfAbsent(entry.getKey(), k -> new ArrayList<>())
                            .add(entry.getValue());
                });
        gradesBySubject.forEach((subject, grades) -> sortedSubjectsByGrades.put(subject.getName(), grades.stream()
                .mapToDouble(Grade::getValue)
                .average()
                .orElse(0)));
        sortedSubjectsByGrades.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach((e) -> System.out.println(e.getKey() + " - " + e.getValue()));
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
