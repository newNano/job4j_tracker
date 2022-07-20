package ru.job4j.inheritance;

public class Doctor extends Profession {
    private boolean isKnowAnatomy;

    public Doctor(String name,
                  String surname,
                  String education,
                  String birthday,
                  boolean isKnowAnatomy) {
        super(name, surname, education, birthday);
        this.isKnowAnatomy = isKnowAnatomy;
    }

    public Diagnosis heal(Pacient pacient) {
        return null;
    }
}
