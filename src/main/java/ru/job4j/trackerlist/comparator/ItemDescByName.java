package ru.job4j.trackerlist.comparator;

import ru.job4j.trackerlist.Item;
import java.util.Comparator;

public class ItemDescByName implements Comparator<Item> {
    @Override
    public int compare(Item left, Item rigth) {
        return rigth.getName().compareTo(left.getName());
    }
}
