package ru.job4j.pojo;

public class Book {
    private String title;
    private int countPages;

    public Book(String title, int countPages) {
        this.title = title;
        this.countPages = countPages;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCountPages() {
        return countPages;
    }

    public void setCountPages(int countPages) {
        this.countPages = countPages;
    }
}
