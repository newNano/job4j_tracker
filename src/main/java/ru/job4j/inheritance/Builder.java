package ru.job4j.inheritance;

public class Builder extends Engineer {
    private int experience;

    public Builder(String name, String surname, String education, String birthday, boolean isKnowMath, int experience) {
        super(name, surname, education, birthday, isKnowMath);
        this.experience = experience;
    }

    public void build() {
    }
}
