package ru.job4j.inheritance;

public class Dentist extends Doctor {
    private boolean isStudy;

    public Dentist(String name,
                   String surname,
                   String education,
                   String birthday,
                   boolean isKnowAnatomy,
                   boolean isStudy) {
        super(name, surname, education, birthday, isKnowAnatomy);
        this.isStudy = isStudy;
    }

    public void makeDenture() {
    }
}
