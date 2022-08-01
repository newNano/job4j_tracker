package ru.job4j.trackerlist;

public interface UserAction {
    String name();

    boolean execute(Input input, Tracker tracker);
}
