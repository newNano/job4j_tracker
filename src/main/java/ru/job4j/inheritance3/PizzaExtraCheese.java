package ru.job4j.inheritance3;

public class PizzaExtraCheese extends Pizza {
    @Override
    public String name() {
        return super.name() + " + extra cheese";
    }
}
