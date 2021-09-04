package ru.job4j.inheritance;

public class Surgeon extends Doctor {
    private String fieldSurgery;

    public Surgeon(String name, String surname, String education, String birthday, boolean isKnowAnatomy, String fieldSurgery) {
        super(name, surname, education, birthday, isKnowAnatomy);
        this.fieldSurgery = fieldSurgery;
    }

    public void doOpeartion() {
    }
}
