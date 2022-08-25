package ru.job4j.departments;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Departments {
    public static List<String> fillGaps(List<String> deps) {
        Set<String> tmp = new LinkedHashSet<>();
        StringBuilder start = new StringBuilder();
        for (String value : deps) {
            String[] strArr = value.split("/");
            start.append(strArr[0]);
            tmp.add(start.toString());

            for (int i = 1; i < strArr.length; i++) {
                start.append("/").append(strArr[i]);
                tmp.add(start.toString());
            }
            start.setLength(0);
        }
        return new ArrayList<>(tmp);
    }

    public static void sortAsc(List<String> orgs) {
        orgs.sort(Comparator.naturalOrder());
    }

    public static void sortDesc(List<String> orgs) {
        orgs.sort(new DepDescComp());
    }
}
