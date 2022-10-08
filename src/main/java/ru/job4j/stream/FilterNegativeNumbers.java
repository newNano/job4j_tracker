package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterNegativeNumbers {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(56, -3, 2, 0, -5, -6, 12, 23, -33, 0, 11);
        List<Integer> positive = numbers.stream()
                                .filter(num -> num >= 0)
                                .collect(Collectors.toList());
        positive.forEach(System.out::println);
    }
}
