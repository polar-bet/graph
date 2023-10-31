package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu extends Validation {

    public Menu() {
        Function function = new Function();
        printMenu();
        try {
            switch (choice()) {
                case "1" -> function.printNodeList();
                case "2" -> function.findNode();
                case "3" -> function.findChildren();
                case "4" -> function.findShortestPath();
                case "0" -> System.exit(0);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            new Menu();
        }
    }

    public void printMenu() {
        System.out.println("1 - Список нодів");
        System.out.println("2 - Знайти ноду");
        System.out.println("3 - Знайти нащадки ноди");
        System.out.println("4 - Знайти найкоротший шлях");
        System.out.println("0 - Вийти з програми");
    }

    public String choice() {
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.next();
        switch (choice) {
            case "0", "1", "2", "3", "4" -> {
                return choice;
            }
            default -> {
                return choice();
            }
        }
    }

}
