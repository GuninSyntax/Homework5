package main_tasks.House;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Collections;

public class House {
    static Map<String, Integer> addResidents() {
        Map<String, Integer> residents = new HashMap<>();
        residents.put("Володаева Светлана Игоревна", 17);
        residents.put("Кутягин Михаил Дмитриевич", 14);
        residents.put("Набоков Сергей Юрьевич", 19);
        residents.put("Харин Николай Васильевич", 10);
        residents.put("Агутин Алан Бурбекович", 52);
        residents.put("Нихапов Виктор Викторович", 35);
        residents.put("Узумаке Наруто Хогагьевич", 16);
        residents.put("Учика Саске Безбратович", 16);
        residents.put("Яковлев Игорь Харитонович", 48);
        residents.put("Путин Владимир Владимирович", 71);
        return residents;
    }

    static List<String> identifyAdults(Map<String, Integer> residents) {
        List<String> adultResidents = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : residents.entrySet()) {
            if (entry.getValue() >= 18) {
                adultResidents.add(entry.getKey());
            }
        }
        return adultResidents;
    }

    static void printAdultResidents(List<String> adultResidents) {
        for (int i = 0; i < adultResidents.size(); i++) {
            System.out.println(i + 1 + ". " + adultResidents.get(i));
        }
    }

    public static void main(String[] args) {
        Map<String, Integer> residents = addResidents();
        List<String> adultResidents = identifyAdults(residents);
        Collections.sort(adultResidents);
        printAdultResidents(adultResidents);
    }
}
