package ru.job4j.trackerlist;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import java.util.List;
import ru.job4j.trackerlist.inputimpl.StubInput;
import ru.job4j.trackerlist.outimpl.ConsoleOutput;
import ru.job4j.trackerlist.outimpl.StubOutput;
import ru.job4j.trackerlist.useractionimpl.CreateAction;
import ru.job4j.trackerlist.useractionimpl.DeleteAction;
import ru.job4j.trackerlist.useractionimpl.ExitAction;
import ru.job4j.trackerlist.useractionimpl.FindItemByIdAction;
import ru.job4j.trackerlist.useractionimpl.FindItemsByNameAction;
import ru.job4j.trackerlist.useractionimpl.ReplaceAction;
import ru.job4j.trackerlist.useractionimpl.ShowingAllItems;

class StartUITest {
    @Test
    public void whenCreateItem() {
        Output output = new ConsoleOutput();
        Input in = new StubInput(
                List.of("0", "Item name", "1")
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = List.of(
                new CreateAction(output),
                new ExitAction()
        );
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findAll().get(0).getName()).isEqualTo("Item name");
    }

    @Test
    public void whenReplaceItem() {
        Output output = new ConsoleOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Input in = new StubInput(
                List.of("0", String.valueOf(item.getId()), replacedName, "1")
        );
        List<UserAction> actions = List.of(
                new ReplaceAction(output),
                new ExitAction()
        );
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName()).isEqualTo(replacedName);
    }

    @Test
    public void whenDeleteItem() {
        Output output = new ConsoleOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item"));
        Input in = new StubInput(
                List.of("0", String.valueOf(item.getId()), "1")
        );
        List<UserAction> actions = List.of(
                new DeleteAction(output),
                new ExitAction()
        );
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId())).isEqualTo(null);
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                List.of("0")
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = List.of(
                new ExitAction()
        );
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu." + ln
                + "0. Exit" + ln
        );
    }

    @Test
    public void whenFindAllItems() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("item-1"));
        Item item2 = tracker.add(new Item("item-2"));
        Item item3 = tracker.add(new Item("item-3"));
        Input in = new StubInput(
                List.of("0", "1")
        );
        List<UserAction> actions = List.of(
                new ShowingAllItems(output),
                new ExitAction()
        );
        new StartUI(output).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo("Menu." + ln
                + "0. Show all items" + ln
                + "1. Exit" + ln
                + "=== Show all items ====" + ln
                + item1 + ln
                + item2 + ln
                + item3 + ln
                + "Menu." + ln
                + "0. Show all items" + ln
                + "1. Exit" + ln
        );
    }

    @Test
    public void whenFindItemsByName() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("itemA"));
        Item item2 = tracker.add(new Item("itemB"));
        Item item3 = tracker.add(new Item("itemC"));
        Item item4 = tracker.add(new Item("itemA"));
        Item item5 = tracker.add(new Item("itemC"));
        String name = "itemA";
        Input in = new StubInput(
                List.of("0", name, "1")
        );
        List<UserAction> actions = List.of(
                new FindItemsByNameAction(output),
                new ExitAction()
        );
        new StartUI(output).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "Menu." + ln
                + "0. Find items by name" + ln
                + "1. Exit" + ln
                + "=== Find items by name ====" + ln
                + item1 + ln
                + item4 + ln
                + "Menu." + ln
                + "0. Find items by name" + ln
                + "1. Exit" + ln
        );
    }

    @Test
    public void whenFindItemById() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("itemA"));
        Item item2 = tracker.add(new Item("itemB"));
        Item item3 = tracker.add(new Item("itemC"));
        Item item4 = tracker.add(new Item("itemD"));
        Item item5 = tracker.add(new Item("itemE"));
        Input in = new StubInput(
                List.of("0", String.valueOf(item4.getId()), "1")
        );
        List<UserAction> actions = List.of(
                new FindItemByIdAction(output),
                new ExitAction()
        );
        new StartUI(output).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "Menu." + ln
                + "0. Find item by id" + ln
                + "1. Exit" + ln
                + "=== Find item by id ====" + ln
                + item4 + ln
                + "Menu." + ln
                + "0. Find item by id" + ln
                + "1. Exit" + ln
        );
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                List.of("1", "0")
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = List.of(
                new ExitAction()
        );
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu." + ln
                + "0. Exit" + ln
                + "Wrong input, you can select: 0 .. 0" + ln
                + "Menu." + ln
                + "0. Exit" + ln
        );
    }
}