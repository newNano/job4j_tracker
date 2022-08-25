package ru.job4j.departments;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] o1Arr = o1.split("/");
        String[] o2Arr = o2.split("/");
        int lenMin = Math.min(o1Arr.length, o2Arr.length);
        for (int i = 0; i < lenMin; i++) {
            int compare = 0;
            if (i == 0) {
                compare = o2Arr[i].compareTo(o1Arr[i]);
            } else {
                compare = o1Arr[i].compareTo(o2Arr[i]);
            }

            if (compare != 0) {
                return compare;
            }
        }
        return Integer.compare(o1Arr.length, o2Arr.length);
    }
}
