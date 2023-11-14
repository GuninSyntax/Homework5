package main_tasks.Olympics;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student
                ("Дмитрий", "Олегов", "Васильевич", new ArrayList<Integer>() {{
                    add(82);
                    add(58);
                    add(28);
                }});
        Student student2 = new Student
                ("Михаил", "Галкин", "Юрьевич", new ArrayList<Integer>() {{
                    add(90);
                    add(95);
                    add(10);
                }});
        Student student3 = new Student
                ("Сергей", "Хмуров", "Ренатович", new ArrayList<Integer>() {{
                    add(45);
                    add(40);
                    add(86);
                }});
        Student student4 = new Student
                ("Алексей", "Лаптев", "Валерьевич", new ArrayList<Integer>() {{
                    add(60);
                    add(50);
                    add(10);
                }});
        Student student5 = new Student
                ("Василий", "Зябликов", "Михайлович", new ArrayList<Integer>() {{
                    add(100);
                    add(99);
                    add(86);
                }});
        Student student6 = new Student
                ("Анна", "Рябина", "Васильевна", new ArrayList<Integer>() {{
                    add(42);
                    add(34);
                    add(56);
                }});
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
