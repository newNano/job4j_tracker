package ru.job4j.oop;

public class Error {
    private boolean active;
    private int status;
    private String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void showInfo() {
        System.out.println("Активность ошибки: " + active);
        System.out.println("Статус ошибки: " + status);
        System.out.println("Текст ошибки: " + message + "\n");
    }

    public static void main(String[] args) {
        Error error1 = new Error();
        Error error2 = new Error(false, 2, "Ошибоки отсутсвуют");
        Error error3 = new Error(true, 1, "Ошибка номер 1");
        Error error4 = new Error(true, 3, "Ошибка номер 3");
        error1.showInfo();
        error2.showInfo();
        error3.showInfo();
        error4.showInfo();
    }
}
