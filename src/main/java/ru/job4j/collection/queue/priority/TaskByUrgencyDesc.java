package ru.job4j.collection.queue.priority;

import java.util.Comparator;

public class TaskByUrgencyDesc implements Comparator<Task> {

    @Override
    public int compare(Task o1, Task o2) {
        return Integer.compare(o2.urgency(), o1.urgency());
    }
}