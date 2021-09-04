package ru.job4j.inheritance;

public class Engineer extends Profession {
    private boolean isKnowMath;

    public Engineer(String name, String surname, String education, String birthday, boolean isKnowMath) {
        super(name, surname, education, birthday);
        this.isKnowMath = isKnowMath;
    }

    public boolean fix(Task task) {
        return false;
    }
}
