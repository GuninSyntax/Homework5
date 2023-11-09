package main_tasks.Lottery;
import java.util.Random;

public class Lottery {
    public static void main(String[] args) {
        int[] numbersOfLottery = mixingNumbers(initNumbersLottery());
        printFirstNumbers(numbersOfLottery);
    }

    static int[] initNumbersLottery() {
        int[] numbersOfLottery = new int[100];
        for (int i = 0; i < numbersOfLottery.length; i++) {
            numbersOfLottery[i] = i;
        }
        return numbersOfLottery;
    }

    static int[] mixingNumbers(int[] numbersOfLottery) {
        Random random = new Random();
        for (int i = 0; i < numbersOfLottery.length; i++) {
            int value = random.nextInt(100);
            int temp = numbersOfLottery[value];
            numbersOfLottery[value] = numbersOfLottery[i];
            numbersOfLottery[i] = temp;
        }
        return numbersOfLottery;
    }

    static void printFirstNumbers(int[] numbersOfLottery) {
        for (int i = 0; i < 10; i++) {
            System.out.print(numbersOfLottery[i] + " ");
        }
    }
}
