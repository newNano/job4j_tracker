package ru.job4j.trackerlist.useractionimpl;

import ru.job4j.trackerlist.Input;
import ru.job4j.trackerlist.Item;
import ru.job4j.trackerlist.Output;
import ru.job4j.trackerlist.Tracker;
import ru.job4j.trackerlist.UserAction;

public class FindItemsByNameAction implements UserAction {
    private final Output out;

    public FindItemsByNameAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find items by name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Find items by name ====");
        String name = input.askStr("Enter name: ");
        Item[] items = tracker.findByName(name);
        if (items.length > 0) {
            for (Item item : items) {
                out.println(item);
            }
        } else {
            out.println("Заявки с именем: " + name + " не найдены.");
        }
        return true;
    }
}
