package ru.job4j.collection.queue;

import java.util.Queue;

public class AppleStore {

    private final Queue<Customer> queue;
    private final int count;

    public AppleStore(Queue<Customer> queue, int count) {
        this.queue = queue;
        this.count = count;
    }

    public String getLastHappyCustomer() {
        for (int i = 1; i < count; i++) {
            queue.poll();
        }
        return queue.poll().name();
    }

    public String getFirstUpsetCustomer() {
        getLastHappyCustomer();
        return queue.poll().name();
    }
}