package ru.job4j.poly;

public class PolyUsage {
    public static void main(String[] args) {
        Vehicle autobus = new Autobus();
        Vehicle airplane = new Airplane();
        Vehicle train = new Train();
        Vehicle[] vehicles = {autobus, airplane, train};
        for (Vehicle vehicle : vehicles) {
            vehicle.move();
        }
    }
}
