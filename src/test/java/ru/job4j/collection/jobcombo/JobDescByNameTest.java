package ru.job4j.collection.jobcombo;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.*;

class JobDescByNameTest {
    @Test
    public void whenComparatorByDescJobName() {
        List<Job> jobs = Arrays.asList(
                new Job("Read code", 2),
                new Job("Fix bug", 3),
                new Job("Analyze code", 6),
                new Job("Conduct a technical interview", 4),
                new Job("Participate in an online meeting", 7),
                new Job("Write code", 1),
                new Job("Impl task", 5),
                new Job("Participate in an offline session", 8)
        );
        jobs.sort(new JobDescByName());
        List<Job> expected = Arrays.asList(
                new Job("Write code", 1),
                new Job("Read code", 2),
                new Job("Participate in an online meeting", 7),
                new Job("Participate in an offline session", 8),
                new Job("Impl task", 5),
                new Job("Fix bug", 3),
                new Job("Conduct a technical interview", 4),
                new Job("Analyze code", 6)
        );
        assertThat(jobs).isEqualTo(expected);
    }
}