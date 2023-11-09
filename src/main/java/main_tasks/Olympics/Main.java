package main_tasks.Olympics;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student
                ("Дмитрий", "Олегов", "Васильевич", 56, 23, 75);
        Student student2 = new Student
                ("Михаил", "Галкин", "Юрьевич", 45, 20, 99);
        Student student3 = new Student
                ("Сергей", "Хмуров", "Ренатович", 10, 54, 78);
        Student student4 = new Student
                ("Алексей", "Лаптев", "Валерьевич", 83, 66, 12);
        Student student5 = new Student
                ("Василий", "Зябликов", "Михайлович", 99, 100, 70);
        Student student6 = new Student
                ("Анна", "Рябина", "Васильевна", 99, 100, 69);
        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);
        students.add(student6);
        Student.findOutTheWinners(students);
    }
}
