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

    public Student(String name, String surname, String patronymic, int point1, int point2, int point3) {
        this.score = new ArrayList<>();
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.score.add(point1);
        this.score.add(point2);
        this.score.add(point3);
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
        double sum = 0;
        for (Integer integer : score) {
            sum += integer;
        }
        return (sum + 0.0) / score.size();
    }

    private static double getTotalScoreStudent(List<Integer> score) {
        double sum = 0;
        for (Integer integer : score) {
            sum += integer;
        }
        return sum;
    }

    private static void printWinners(List<Student> winners) {
        String s = null;
        for (int i = 0; i < winners.size(); i++) {
            s = i + 1 < 4 ? "МЕСТО" : "место";
            System.out.print(i + 1 + " " + s + ": ");
            System.out.print(winners.get(i).getSurname() + " ");
            System.out.println(winners.get(i).getName() + " " + winners.get(i).getPatronymic());
            System.out.print("Общее количество баллов студента " + (winners.get(i).getSurname()) + " ");
            System.out.print((winners.get(i).getName()) + " " + winners.get(i).getName() + ": ");
            System.out.println(getTotalScoreStudent(winners.get(i).getScore()));
            System.out.println("Среднее арифметическое кол-во баллов: " + getScoreStudent(winners.get(i).getScore()));
            System.out.println();
        }
    }
}
