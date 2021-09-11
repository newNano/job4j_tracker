package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Игра 11." + System.lineSeparator());
        boolean turn = true;
        int count = 11;
        while (count > 0) {
            boolean isNotCorrect = true;
            System.out.println("Количество спичек на столе " + count);
            String player = turn ? "Первый игрок" : "Второй игрок";
            if (count < 4) {
                System.out.println(player + " забрал последние спички");
                break;
            }
            int matches = 0;
            while (isNotCorrect) {
                System.out.print(player + " введите число от 1 до 3: ");
                matches = Integer.parseInt(input.nextLine());
                if (matches > 0 && matches < 4) {
                    isNotCorrect = false;
                } else {
                    System.out.println("Значение вне диапазона.");
                }
            }
            count -= matches;
            turn = !turn;
            System.out.println();
        }
        if (turn) {
            System.out.println("Выиграл первый игрок");
        } else {
            System.out.println("Выиграл второй игрок");
        }
    }
}
