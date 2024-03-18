package ru.penzgtu;

import ru.penzgtu.model.Pet;
import ru.penzgtu.model.WildAnimal;

public class Main {
    public static void main(String[] args) {
        Pet cat = new Pet("млекопитающее", "кошачьи",
                4, 5, "Мурка");

        WildAnimal wolf = new WildAnimal("млекопитающее", "псовые",
                4, 1, "Лес");

        System.out.println("===== Кошка =====");
        cat.print();
        cat.printFeedingMethod();

        System.out.println("\n===== Волк =====");
        wolf.print();
        wolf.printFeedingMethod();
    }
}