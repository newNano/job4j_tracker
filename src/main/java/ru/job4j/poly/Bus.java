package ru.job4j.poly;

public class Bus implements Transport {

    @Override
    public void drive() {
        System.out.println("Поехали");
    }

    @Override
    public void passengers(int people) {
        System.out.println("Принятие пассажиров");
    }

    @Override
    public int fill(int fuel) {
        return 0;
    }
}
