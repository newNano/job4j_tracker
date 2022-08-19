package ru.job4j.collection.strcomparator;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        if (left.equals(right)) {
            return 0;
        }
        if (left.length() <= right.length()) {
            for (int i = 0; i < left.length(); i++) {
                int compare = Character.compare(left.charAt(i), right.charAt(i));
                if (compare == 0) {
                    continue;
                }
                return compare;
            }
        }
        return -1;
    }
}
