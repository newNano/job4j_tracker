package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.nullValue;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        Output output = new ConsoleOutput();
        Input in = new StubInput(
                new String[]{"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(output),
                new ExitAction()
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Output output = new ConsoleOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), replacedName, "1"}
        );
        UserAction[] actions = {
                new ReplaceAction(output),
                new ExitAction()
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Output output = new ConsoleOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item"));
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), "1"}
        );
        UserAction[] actions = {
                new DeleteAction(output),
                new ExitAction()
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. Exit" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindAllItems() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        tracker.add(new Item("item-1"));
        tracker.add(new Item("item-2"));
        tracker.add(new Item("item-3"));
        Input in = new StubInput(
                new String[]{"0", "1"}
        );
        UserAction[] actions = {
                new ShowingAllItems(output),
                new ExitAction()
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(output.toString(), is("Menu." + System.lineSeparator()
                                                + "0. Show all items" + System.lineSeparator()
                                                + "1. Exit" + System.lineSeparator()
                                                + "=== Show all items ====" + System.lineSeparator()
                                                + "Item{id=" + tracker.findAll()[0].getId() + ", name='" + tracker.findAll()[0].getName() + "\'}" + System.lineSeparator()
                                                + "Item{id=" + tracker.findAll()[1].getId() + ", name='" + tracker.findAll()[1].getName() + "\'}" + System.lineSeparator()
                                                + "Item{id=" + tracker.findAll()[2].getId() + ", name='" + tracker.findAll()[2].getName() + "\'}" + System.lineSeparator()
                                                + "Menu." + System.lineSeparator()
                                                + "0. Show all items" + System.lineSeparator()
                                                + "1. Exit" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindItemsByName() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        tracker.add(new Item("itemA"));
        tracker.add(new Item("itemB"));
        tracker.add(new Item("itemC"));
        tracker.add(new Item("itemA"));
        tracker.add(new Item("itemC"));
        String name = "itemA";
        Input in = new StubInput(
                new String[]{"0", name, "1"}
        );
        UserAction[] actions = {
                new FindItemsByNameAction(output),
                new ExitAction()
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(output.toString(), is("Menu." + System.lineSeparator()
                                        + "0. Find items by name" + System.lineSeparator()
                                        + "1. Exit" + System.lineSeparator()
                                        + "=== Find items by name ====" + System.lineSeparator()
                                        + "Item{id=" + tracker.findAll()[0].getId() + ", name='" + tracker.findAll()[0].getName() + "\'}" + System.lineSeparator()
                                        + "Item{id=" + tracker.findAll()[3].getId() + ", name='" + tracker.findAll()[3].getName() + "\'}" + System.lineSeparator()
                                        + "Menu." + System.lineSeparator()
                                        + "0. Find items by name" + System.lineSeparator()
                                        + "1. Exit" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindItemById() {
        Output output = new ConsoleOutput();
        Tracker tracker = new Tracker();
        tracker.add(new Item("itemA"));
        tracker.add(new Item("itemB"));
        tracker.add(new Item("itemC"));
        tracker.add(new Item("itemD"));
        tracker.add(new Item("itemE"));
        Input in = new StubInput(
                new String[]{"0", "4", "1"}
        );
        UserAction[] actions = {
                new FindItemByIdAction(output),
                new ExitAction()
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findById(4).getName(), is("itemD"));
    }
}