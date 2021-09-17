package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ValidateInputTest {

    @Test
    public void whenInvalidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"one", "1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(1));
    }

    @Test
    public void whenCorrectInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(1));
    }

    @Test
    public void whenMultipleCorrectInput() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Input in = new StubInput(
                new String[]{"0", "Petr", "1", "2"}
        );
        ValidateInput input = new ValidateInput(out, in);
        UserAction[] actions = {
                new CreateAction(out),
                new ShowingAllItems(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("Menu." + ln
                + "0. Add new Item" + ln
                + "1. Show all items" + ln
                + "2. Exit" + ln
                + "=== Create a new Item ====" + ln
                + "Добавленная заявка: " + tracker.findAll()[0] + ln
                + "Menu." + ln
                + "0. Add new Item" + ln
                + "1. Show all items" + ln
                + "2. Exit" + ln
                + "=== Show all items ====" + ln
                + tracker.findAll()[0] + ln
                + "Menu." + ln
                + "0. Add new Item" + ln
                + "1. Show all items" + ln
                + "2. Exit" + ln
        ));
    }

    @Test
    public void whenInputNegativeNumber() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"-1", "0"}
        );
        ValidateInput input = new ValidateInput(out, in);
        UserAction[] actions = {
                new ExitAction()
        };
        new StartUI(out).init(in, new Tracker(), actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("Menu." + ln
                                    + "0. Exit" + ln
                                    + "Wrong input, you can select: 0 .. 0" + ln
                                    + "Menu." + ln
                                    + "0. Exit" + ln
        ));
    }
}