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

    public Student(String name, String surname, String patronymic, int point1, int point2, int point3, int point4) {
        this.score = new ArrayList<>();
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.score.add(point1);
        this.score.add(point2);
        this.score.add(point3);
        this.score.add(point4);
    }
    static void findOutTheWinners(List<Student> students) {
        boolean isSort = false;
        while(!isSort) {
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
        return (score.get(0) + score.get(1) + score.get(2) + score.get(3) + 0.0) / score.size();
    }

    private static void printWinners(List<Student> winners) {
        String s = null;
        for (int i = 0; i < winners.size(); i++) {
            System.out.print(i + 1 + " место: ");
            System.out.print(winners.get(i).getSurname() + " ");
            System.out.println(winners.get(i).getName() + " " + winners.get(i).getPatronymic());
            System.out.println("Среднее арифметическое кол-во баллов: " + getScoreStudent(winners.get(i).getScore()));
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Student student1 = new Student
                ("Дмитрий", "Олегов", "Васильевич", 56, 23, 75, 54);
        Student student2 = new Student
                ("Михаил", "Галкин", "Юрьевич", 45, 20, 99, 38);
        Student student3 = new Student
                ("Сергей", "Хмуров", "Ренатович", 10, 54, 78, 58);
        Student student4 = new Student
                ("Алексей", "Лаптев", "Валерьевич", 83, 66, 12, 84);
        Student student5 = new Student
                ("Василий", "Зябликов", "Михайлович", 99, 100, 70, 34);
        Student student6 = new Student
                ("Анна", "Рябина", "Васильевна", 99, 100, 69, 45);
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
