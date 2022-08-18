package ru.job4j.collection.jobcombo;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import static org.assertj.core.api.Assertions.*;

class JobTest {
    @Test
    public void whenCompatorByDescNameAndDescPrority() {
        Comparator<Job> cmpNamePriority = new JobDescByName()
                .thenComparing(new JobDescByPriority());
        List<Job> jobs = Arrays.asList(
                new Job("Fix bug", 3),
                new Job("Write code", 1),
                new Job("Analyze code", 6),
                new Job("Read code", 2),
                new Job("Impl task", 5),
                new Job("Analyze code", 4),
                new Job("Write code", 7),
                new Job("Impl task", 8)
        );
        jobs.sort(cmpNamePriority);
        List<Job> expected = Arrays.asList(
                new Job("Write code", 7),
                new Job("Write code", 1),
                new Job("Read code", 2),
                new Job("Impl task", 8),
                new Job("Impl task", 5),
                new Job("Fix bug", 3),
                new Job("Analyze code", 6),
                new Job("Analyze code", 4)
        );
        assertThat(jobs).isEqualTo(expected);
    }

    @Test
    public void whenCompatorByDescNameAndAscPrority() {
        Comparator<Job> cmpNamePriority = new JobDescByName()
                .thenComparing(new JobAscByPriority());
        List<Job> jobs = Arrays.asList(
                new Job("Fix bug", 3),
                new Job("Write code", 1),
                new Job("Analyze code", 6),
                new Job("Read code", 2),
                new Job("Impl task", 5),
                new Job("Analyze code", 4),
                new Job("Write code", 7),
                new Job("Impl task", 8)
        );
        jobs.sort(cmpNamePriority);
        List<Job> expected = Arrays.asList(
                new Job("Write code", 1),
                new Job("Write code", 7),
                new Job("Read code", 2),
                new Job("Impl task", 5),
                new Job("Impl task", 8),
                new Job("Fix bug", 3),
                new Job("Analyze code", 4),
                new Job("Analyze code", 6)
        );
        assertThat(jobs).isEqualTo(expected);
    }

    @Test
    public void whenCompatorByAscNameAndAscPrority() {
        Comparator<Job> cmpNamePriority = new JobAscByName().
                thenComparing(new JobAscByPriority());
        List<Job> jobs = Arrays.asList(
                new Job("Fix bug", 3),
                new Job("Write code", 1),
                new Job("Analyze code", 6),
                new Job("Read code", 2),
                new Job("Impl task", 5),
                new Job("Analyze code", 4),
                new Job("Write code", 7),
                new Job("Impl task", 8)
        );
        jobs.sort(cmpNamePriority);
        List<Job> expected = Arrays.asList(
                new Job("Analyze code", 4),
                new Job("Analyze code", 6),
                new Job("Fix bug", 3),
                new Job("Impl task", 5),
                new Job("Impl task", 8),
                new Job("Read code", 2),
                new Job("Write code", 1),
                new Job("Write code", 7)
        );
        assertThat(jobs).isEqualTo(expected);
    }

    @Test
    public void whenCompatorByAscNameAndDescPrority() {
        Comparator<Job> cmpNamePriority = new JobAscByName().
                thenComparing(new JobDescByPriority());
        List<Job> jobs = Arrays.asList(
                new Job("Fix bug", 3),
                new Job("Write code", 1),
                new Job("Analyze code", 6),
                new Job("Read code", 2),
                new Job("Impl task", 5),
                new Job("Analyze code", 4),
                new Job("Write code", 7),
                new Job("Impl task", 8)
        );
        jobs.sort(cmpNamePriority);
        List<Job> expected = Arrays.asList(
                new Job("Analyze code", 6),
                new Job("Analyze code", 4),
                new Job("Fix bug", 3),
                new Job("Impl task", 8),
                new Job("Impl task", 5),
                new Job("Read code", 2),
                new Job("Write code", 7),
                new Job("Write code", 1)
        );
        assertThat(jobs).isEqualTo(expected);
    }
}