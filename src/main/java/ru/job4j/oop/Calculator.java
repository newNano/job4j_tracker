package ru.job4j.oop;

public class Calculator {
    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public static int minus(int y) {
        return y - x;
    }

    public int multiply(int a) {
        return x * a;
    }

    public int divide(int y) {
        return y / x;
    }

    public int sumAllOperation(int y) {
        return sum(y) + minus(y) + multiply(y) + divide(y);
    }

    public static void main(String[] args) {
        int result = sum(10);
        System.out.println("Operation sum(10): " + result);

        result = minus(7);
        System.out.println("Operation minus(7): " + result);

        Calculator calculator = new Calculator();
        int rsl = calculator.multiply(5);
        System.out.println("Operation multiply(5): " + rsl);

        rsl = calculator.divide(16);
        System.out.println("Operation divide(10): " + rsl);

        rsl = calculator.sumAllOperation(20);
        System.out.println("Operation sumAllOperation(20): " + rsl);

    }
}
