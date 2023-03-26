package ru.job4j.collection.queue.priority;

public record Task(Position position,
                   String description,
                   int urgency) {
}