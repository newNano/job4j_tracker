package ru.job4j.trackerlist.useractionimpl;

import ru.job4j.trackerlist.Input;
import ru.job4j.trackerlist.Item;
import ru.job4j.trackerlist.Output;
import ru.job4j.trackerlist.Tracker;
import ru.job4j.trackerlist.UserAction;

import java.util.List;

public class ShowingAllItems implements UserAction {
    private final Output out;

    public ShowingAllItems(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Show all items";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Show all items ====");
        List<Item> items = tracker.findAll();
        if (items.size() > 0) {
            for (Item item : items) {
                out.println(item);
            }
        } else {
            out.println("Хранилище еще не содержит заявок");
        }
        return true;
    }
}
