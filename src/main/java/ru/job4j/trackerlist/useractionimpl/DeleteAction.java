package ru.job4j.trackerlist.useractionimpl;

import ru.job4j.trackerlist.Input;
import ru.job4j.trackerlist.Output;
import ru.job4j.trackerlist.Tracker;
import ru.job4j.trackerlist.UserAction;

public class DeleteAction implements UserAction {
    private final Output out;

    public DeleteAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Delete item ====");
        int id = input.askInt("Enter id: ");
        if (tracker.delete(id)) {
            out.println("Заявка удалена успешно.");
        } else {
            out.println("Ошибка удаления заявки.");
        }
        return true;
    }
}
