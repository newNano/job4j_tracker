package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    public Item[] findAll() {
        Item[] temps = new Item[size];
        int index = 0;
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null) {
                temps[index++] = items[i];
            }
        }
        return temps;
    }

    public Item[] findByName(String key) {
        Item[] temps = new Item[size];
        int index = 0;
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null && key.equals(items[i].getName())) {
                temps[index++] = items[i];
            }
        }
        temps = Arrays.copyOf(temps, index);
        return temps;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int i = 0; i < size; i++) {
            if (items[i].getId() == id) {
                rsl = i;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item tempItem) {
        int index = indexOf(id);
        if (index == -1) {
            return false;
        }
        tempItem.setId(id);
        items[index] = tempItem;
        return true;
    }
}