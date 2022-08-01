package ru.job4j.trackerlist.useractionimpl;

import ru.job4j.trackerlist.Input;
import ru.job4j.trackerlist.Item;
import ru.job4j.trackerlist.Output;
import ru.job4j.trackerlist.Tracker;
import ru.job4j.trackerlist.UserAction;

public class CreateAction implements UserAction {
    private final Output out;

    public CreateAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Add new Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Create a new Item ====");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
        out.println("Добавленная заявка: " + item);
        return true;
    }
}
