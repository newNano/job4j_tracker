package ru.job4j.inheritance;

public class Programmer extends Engineer {
    private String language;

    public Programmer(String name,
                      String surname,
                      String education,
                      String birthday,
                      boolean isknowMath,
                      String language) {
        super(name, surname, education, birthday, isknowMath);
        this.language = language;
    }

    public void doProgram() {
    }
}
