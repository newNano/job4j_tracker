package ru.job4j.collection.queue;

import java.util.Queue;

public class AppleStore {

    private final Queue<Customer> queue;
    private final int count;
    private int c = 1;

    public AppleStore(Queue<Customer> queue, int count) {
        this.queue = queue;
        this.count = count;
    }

    public String getLastHappyCustomer() {
        while (c++ < count) {
            queue.poll();
        }
        return queue.poll().name();
    }

    public String getFirstUpsetCustomer() {
        getLastHappyCustomer();
        return queue.poll().name();
    }
}