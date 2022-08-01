package ru.job4j.trackerlist.outimpl;

import ru.job4j.trackerlist.Output;

public class ConsoleOutput implements Output {
    @Override
    public void println(Object obj) {
        System.out.println(obj);
    }
}
