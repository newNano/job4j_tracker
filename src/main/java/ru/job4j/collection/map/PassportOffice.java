package ru.job4j.collection.map;

import java.util.HashMap;
import java.util.Map;

public class PassportOffice {
    private Map<String, Citizen> citizens = new HashMap<>();

    public boolean add(Citizen citizen) {
        boolean isNotContains = !citizens.containsKey(citizen.getPassport());
        if (isNotContains) {
            citizens.put(citizen.getPassport(), citizen);
        }
        return isNotContains;
    }

    public Citizen get(String passport) {
        return citizens.get(passport);
    }
}
