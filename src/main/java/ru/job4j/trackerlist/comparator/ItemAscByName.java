package ru.job4j.trackerlist.comparator;

import ru.job4j.trackerlist.Item;
import java.util.Comparator;

public class ItemAscByName implements Comparator<Item> {
    @Override
    public int compare(Item left, Item rigth) {
        return left.getName().compareTo(rigth.getName());
    }
}
