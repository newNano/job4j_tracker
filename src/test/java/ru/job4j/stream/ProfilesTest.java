package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class ProfilesTest {
    @Test
    public void whenTestMethodCollect() {
        Address first = new Address("City1", "Street1", 1, 1);
        Address second = new Address("City2", "Street2", 2, 2);
        Address third = new Address("City3", "Street3", 3, 3);
        List<Profile> profiles = Arrays.asList(
                new Profile(first),
                new Profile(second),
                new Profile(third)
        );
        List<Address> result = Profiles.collect(profiles);
        List<Address> expected = Arrays.asList(first, second, third);
        assertThat(result).containsAll(expected);
    }
}