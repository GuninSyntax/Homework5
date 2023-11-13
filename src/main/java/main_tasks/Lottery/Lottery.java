package main_tasks.Lottery;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottery {
    public static void main(String[] args) {
        List <Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        for (int i = 0; i < 10; i++) {
            System.out.print(numbers.get(i) + " ");
        }
    }
}
