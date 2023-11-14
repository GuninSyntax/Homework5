package main_tasks.Olympics;

import java.util.*;

public class Student {
    private String name;
    private String surname;
    private String patronymic;
    private List<Integer> score;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public List<Integer> getScore() {
        return score;
    }

    public void setScore(List<Integer> score) {
        this.score = score;
    }

    public Student(String name, String surname, String patronymic,List<Integer> score) {
        this.score = score;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
    }

    static void findOutTheWinners(List<Student> students) {
        boolean isSort = false;
        while (!isSort) {
            isSort = true;
            for (int i = 0; i < students.size() - 1; i++) {
                if (getScoreStudent(students.get(i).getScore()) < getScoreStudent(students.get(i + 1).getScore())) {
                    isSort = false;
                    Student temp = students.get(i);
                    students.set(i, students.get(i + 1));
                    students.set(i + 1, temp);
                }
            }
        }
        printWinners(students);
    }

    private static double getScoreStudent(List<Integer> score) {
        double sum = 0;
        for (Integer integer : score) {
            sum += integer;
        }
        return (sum + 0.0) / score.size();
    }

    private static void printWinners(List<Student> winners) {
        for (int i = 0; i < winners.size(); i++) {
            System.out.print(i + 1 + " место: ");
            System.out.print(winners.get(i).getSurname() + " ");
            System.out.println(winners.get(i).getName() + " " + winners.get(i).getPatronymic());
            System.out.println("Среднее арифметическое кол-во баллов: " + getScoreStudent(winners.get(i).getScore()));
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Student student1 = new Student("Дмитрий", "Олегов", "Васильевич", new ArrayList<Integer>() {{
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
