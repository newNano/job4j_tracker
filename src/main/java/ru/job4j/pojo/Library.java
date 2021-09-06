package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book book1 = new Book("Структуры данных и алгоритмы Java", 702);
        Book book2 = new Book("Полное руководство. Java 8", 1377);
        Book book3 = new Book("Clean code", 466);
        Book book4 = new Book("Философия Java", 1170);
        Book[] books = new Book[4];
        books[0] = book1;
        books[1] = book2;
        books[2] = book3;
        books[3] = book4;
        for (int index = 0; index < books.length; index++) {
            Book book = books[index];
            System.out.println(book.getTitle() + " - " + book.getCountPages());
        }
        books[0] = book4;
        books[3] = book1;
        for (int index = 0; index < books.length; index++) {
            Book book = books[index];
            System.out.println(book.getTitle() + " - " + book.getCountPages());
        }
        for (int index = 0; index < books.length; index++) {
            Book book = books[index];
            if ("Clean code".equals(book.getTitle())) {
                System.out.println(book.getTitle() + " - " + book.getCountPages());
            }
        }
    }
}
