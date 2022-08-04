package ru.job4j.collection.map;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class PassportOfficeTest {
    @Test
    public void whenTestAddMethod() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertThat(office.get(citizen.getPassport())).isEqualTo(citizen);
    }

    @Test
    public void whenAddCitizenAlreadyContainsInMap() {
        Citizen citizen1 = new Citizen("2f44a", "Petr Arsentev");
        Citizen citizen2 = new Citizen("1b44r", "Ivan Arsentev");
        Citizen citizen3 = new Citizen("2f44a", "Dmitry Petrov");
        PassportOffice office = new PassportOffice();
        office.add(citizen1);
        office.add(citizen2);
        assertThat(office.add(citizen3)).isFalse();
    }
}