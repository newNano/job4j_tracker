package ru.job4j.poly;

public class Autobus implements Vehicle {
    @Override
    public void move() {
        System.out.println("Автобус ездит по скоростной трассе");
    }
}
