package ru.job4j.collection.map.certification;

public record Label(String name, double score) implements Comparable<Label> {
    @Override
    public int compareTo(Label o) {
        return Double.compare(this.score, o.score);
    }
}
