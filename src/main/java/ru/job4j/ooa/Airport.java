package ru.job4j.ooa;

public class Airport {
    public static void main(String[] args) {
        Airbus airbus = new Airbus("A320");
        airbus.printModel();
        airbus.printCountEngine();
        System.out.println();
        airbus = new Airbus("A380");
        airbus.printModel();
        airbus.printCountEngine();
    }
}
