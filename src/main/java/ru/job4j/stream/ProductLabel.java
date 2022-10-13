package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;

public class ProductLabel {
    public List<String> generateLabels(List<Product> products) {
        return products.stream()
                .filter(product -> product.getActual() - product.getStandard() <= 3)
                .map(product -> new Label(product.getName(), product.getPrice() / 2))
                .map(label -> label.toString())
                .collect(Collectors.toList());
    }
}