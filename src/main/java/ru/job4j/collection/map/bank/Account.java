package ru.job4j.collection.map.bank;

import java.util.Objects;

/**
 * Класс описывает счет пользователя.
 * Содержит поля : баланс и реквизиты
 * @author NAZEKOV ULUKBEK
 * @version 1.0
 */
public class Account {
    /**
     * поле является реквизитом счета
     */
    private String requisite;

    /**
     * поле является балансом денег на счету
     */
    private double balance;

    /**
     * Конструктор при создании счета
     * @param requisite - реквизит счета
     * @param balance - баланс счета
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Геттер реквизита. Позволяет получить значение реквизита
     * @return возвращает реквизит счета
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Сеттер реквизита. Позволяет установить новый реквизит данному счету
     * @param requisite - новый реквизит
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Геттер баланса. Позволяет получить значение баланса денег
     * @return возвращает значение баланса денег
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Сеттер баланса. Установка нового баланса денег.
     * @param balance - новый баланс денег.
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}
