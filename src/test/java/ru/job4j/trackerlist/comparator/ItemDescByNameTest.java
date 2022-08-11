package ru.job4j.trackerlist.comparator;

import org.junit.jupiter.api.Test;
import ru.job4j.trackerlist.Item;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

class ItemDescByNameTest {
    @Test
    public void sortDescendingOrderItem() {
        List<Item> items = Arrays.asList(
                new Item(2, "Artem"),
                new Item(1, "Taras"),
                new Item(6, "Ivan"),
                new Item(4, "Vasya"),
                new Item(7, "Dima"),
                new Item(3, "Petr")
        );
        Collections.sort(items, new ItemDescByName());
        List<Item> expected = Arrays.asList(
                new Item(4, "Vasya"),
                new Item(1, "Taras"),
                new Item(3, "Petr"),
                new Item(6, "Ivan"),
                new Item(7, "Dima"),
                new Item(2, "Artem")
        );
        assertThat(items).containsAll(expected);
    }
}