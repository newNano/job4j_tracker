package ru.job4j.collection.map;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("andrey@mail.ru", "Tkachev Andrey Andreevich");
        map.put("dima@gmail.com", "Kostash Dmitry Vladimirovich");
        map.put("vera@yandex.ru", "Vlasova Veronika Petrovna");
        for (String key : map.keySet()) {
            System.out.println(key + " - " + map.get(key));
        }
    }
}
