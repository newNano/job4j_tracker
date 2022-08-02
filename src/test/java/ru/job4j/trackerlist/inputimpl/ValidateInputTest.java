package ru.job4j.trackerlist.inputimpl;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import ru.job4j.trackerlist.Input;
import ru.job4j.trackerlist.Output;
import ru.job4j.trackerlist.StartUI;
import ru.job4j.trackerlist.Tracker;
import ru.job4j.trackerlist.UserAction;
import ru.job4j.trackerlist.outimpl.StubOutput;
import ru.job4j.trackerlist.useractionimpl.CreateAction;
import ru.job4j.trackerlist.useractionimpl.ExitAction;
import ru.job4j.trackerlist.useractionimpl.ShowingAllItems;
import java.util.List;

class ValidateInputTest {
    @Test
    public void whenInvalidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                List.of("one", "1")
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(1);
    }

    @Test
    public void whenCorrectInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                List.of("1")
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(1);
    }

    @Test
    public void whenMultipleCorrectInput() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Input in = new StubInput(
                List.of("0", "Petr", "1", "2")
        );
        ValidateInput input = new ValidateInput(out, in);
        List<UserAction> actions = List.of(
                new CreateAction(out),
                new ShowingAllItems(out),
                new ExitAction()
        );
        new StartUI(out).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString()).isEqualTo(
                "Menu." + ln
                + "0. Add new Item" + ln
                + "1. Show all items" + ln
                + "2. Exit" + ln
                + "=== Create a new Item ====" + ln
                + "Добавленная заявка: " + tracker.findAll().get(0) + ln
                + "Menu." + ln
                + "0. Add new Item" + ln
                + "1. Show all items" + ln
                + "2. Exit" + ln
                + "=== Show all items ====" + ln
                + tracker.findAll().get(0) + ln
                + "Menu." + ln
                + "0. Add new Item" + ln
                + "1. Show all items" + ln
                + "2. Exit" + ln
        );
    }

    @Test
    public void whenInputNegativeNumber() {
        Output out = new StubOutput();
        Input in = new StubInput(
                List.of("-1", "0")
        );
        ValidateInput input = new ValidateInput(out, in);
        List<UserAction> actions = List.of(
                new ExitAction()
        );
        new StartUI(out).init(input, new Tracker(), actions);
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