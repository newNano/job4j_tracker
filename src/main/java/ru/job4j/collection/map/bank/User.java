package ru.job4j.collection.map.bank;

import java.util.Objects;

/**
 * Класс описывает пользователя банковской системы.
 * Содержит поля номер паспорта и ФИО.
 * @author NAZEKOV ULUKBEK
 * @version 1.0
 */
public class User {
    /**
     * Паспорт пользователя
     */
    private String passport;

    /**
     * ФИО пользователя
     */
    private String username;

    /**
     * Конструктор при создании пользователя
     * @param passport - паспорт пользователя
     * @param username - ФИО пользователя
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Геттер паспорта пользователя
     * @return возвращает паспорт пользователя
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Сеттер пользователя. Установка нового пользователя
     * @param passport - новый паспорт пользователя
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Геттер ФИО пользовтеля.
     * @return возвращает ФИО пользователя
     */
    public String getUsername() {
        return username;
    }

    /**
     * Сеттер ФИО пользовтеля. Установка нового ФИО пользователя.
     * @param username - ФИО пользовтеля.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}
