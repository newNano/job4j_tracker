package ru.job4j.trackerlist;

import ru.job4j.trackerlist.inputimpl.ConsoleInput;
import ru.job4j.trackerlist.inputimpl.ValidateInput;
import ru.job4j.trackerlist.outimpl.ConsoleOutput;
import ru.job4j.trackerlist.useractionimpl.CreateAction;
import ru.job4j.trackerlist.useractionimpl.DeleteAction;
import ru.job4j.trackerlist.useractionimpl.ExitAction;
import ru.job4j.trackerlist.useractionimpl.FindItemByIdAction;
import ru.job4j.trackerlist.useractionimpl.FindItemsByNameAction;
import ru.job4j.trackerlist.useractionimpl.ReplaceAction;
import ru.job4j.trackerlist.useractionimpl.ShowingAllItems;
import java.util.List;

public class StartUI {
    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

    public void init(Input input, Tracker tracker, List<UserAction> actions) {
        boolean run = true;
        while (run) {
            showMenu(actions);
            int select = input.askInt("Select command: ");
            if (select < 0 || select >= actions.size()) {
                out.println("Wrong input, you can select: 0 .. " + (actions.size() - 1));
                continue;
            }
            UserAction action = actions.get(select);
            run = action.execute(input, tracker);
        }
    }

    public void showMenu(List<UserAction> actions) {
        out.println("Menu.");
        for (int i = 0; i < actions.size(); i++) {
            out.println(i + ". " + actions.get(i).name());
        }
    }

    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(output, new ConsoleInput());
        Tracker tracker = new Tracker();
        List<UserAction> actions = List.of(new CreateAction(output),
                                        new ShowingAllItems(output),
                                        new ReplaceAction(output),
                                        new DeleteAction(output),
                                        new FindItemByIdAction(output),
                                        new FindItemsByNameAction(output),
                                        new ExitAction());
        new StartUI(output).init(input, tracker, actions);
    }
}