package ru.job4j.trackerlist.useractionimpl;

import ru.job4j.trackerlist.Input;
import ru.job4j.trackerlist.Item;
import ru.job4j.trackerlist.Output;
import ru.job4j.trackerlist.Tracker;
import ru.job4j.trackerlist.UserAction;

public class FindItemByIdAction implements UserAction {
    private final Output out;

    public FindItemByIdAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find item by id";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Find item by id ====");
        int id = input.askInt("Enter id: ");
        Item item = tracker.findById(id);
        if (item != null) {
            out.println(item);
        } else {
            out.println("Заявка с введенным id: " + id + " не найдена.");
        }
        return true;
    }
}
