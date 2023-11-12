package main_tasks.Lottery;

import java.util.Random;

public class Lottery {
    public static void main(String[] args) {
        int[] numbers = new int[100];
        Random random = new Random();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i;
        }
        for (int i = 0; i < numbers.length/2; i++) {
            int randomNumber = random.nextInt(100);
            int temp = numbers[i];
            numbers[i] = numbers[randomNumber];
            numbers[randomNumber] = temp;
        }
        for (int i = 0; i < 10; i++) {
            System.out.print(numbers[i] + " ");
        }
        boolean duplicate = true;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if (numbers[j] == numbers[i] && i != j) duplicate = false;
            }
        }
        if (!duplicate) System.out.println("\nВ МАССИВЕ ЕСТЬ ДУБЛИКАТЫ");
        else System.out.println("\nДУБЛИКАТОВ НЕТ");
    }
}
