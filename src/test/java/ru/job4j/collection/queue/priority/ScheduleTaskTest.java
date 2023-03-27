package ru.job4j.collection.queue.priority;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static ru.job4j.collection.queue.priority.Position.*;

class ScheduleTaskTest {

    @Test
    void whenTwoDirectorTaskThenReadMethodTest() {
        Comparator<Task> comparator = new TaskByPositionAsc()
                                                .thenComparing(new TaskByUrgencyDesc());
        ScheduleTask scheduleTask = new ScheduleTask(comparator);
        scheduleTask.addTask(new Task(DEPARTMENT_HEAD, "description_1", 10));
        scheduleTask.addTask(new Task(DIRECTOR, "description_2", 4));
        scheduleTask.addTask(new Task(DIRECTOR, "description_3", 8));
        String expected = "description_3";
        String result = scheduleTask.readTask().description();
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void whenTwoDepartmentHeadTaskAndEqualUrgencyThenGetMethodTest() {
        Comparator<Task> comparator = new TaskByPositionAsc()
                                                .thenComparing(new TaskByUrgencyDesc());
        ScheduleTask scheduleTask = new ScheduleTask(comparator);
        scheduleTask.addTask(new Task(DEPARTMENT_HEAD, "description_1", 7));
        scheduleTask.addTask(new Task(MANAGER, "description_2", 10));
        scheduleTask.addTask(new Task(DEPARTMENT_HEAD, "description_3", 7));
        String expected = "description_1";
        String result = scheduleTask.getTask().description();
        assertThat(result).isEqualTo(expected);
        scheduleTask.getTask();
        expected = "description_2";
        result = scheduleTask.getTask().description();
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void whenComparatorTaskByPositionAscAndByUrgencyDesc() {
        Comparator<Task> comparator = new TaskByPositionAsc()
                                                .thenComparing(new TaskByUrgencyDesc());
        ScheduleTask scheduleTask = new ScheduleTask(comparator);
        scheduleTask.addTask(new Task(DEPARTMENT_HEAD, "description_1", 10));
        scheduleTask.addTask(new Task(DIRECTOR, "description_2", 4));
        scheduleTask.addTask(new Task(DIRECTOR, "description_3", 8));
        List<Task> list = Arrays.asList(
            scheduleTask.getTask(),
            scheduleTask.getTask(),
            scheduleTask.getTask()
        );
        List<Task> expected = Arrays.asList(
            new Task(DIRECTOR, "description_3", 8),
            new Task(DIRECTOR, "description_2", 4),
            new Task(DEPARTMENT_HEAD, "description_1", 10)
        );
        assertThat(list).isEqualTo(expected);
    }

    @Test
    void whenTwoDirectorTaskThenDepartmentHeadTask() {
        Comparator<Task> comparator = new TaskByPositionAsc()
                .thenComparing(new TaskByUrgencyDesc());
        ScheduleTask scheduleTask = new ScheduleTask(comparator);
        scheduleTask.addTask(new Task(DEPARTMENT_HEAD, "description_1", 10));
        scheduleTask.addTask(new Task(DIRECTOR, "description_2", 4));
        scheduleTask.addTask(new Task(DIRECTOR, "description_3", 8));
        String expected1 = "description_3";
        String result1 = scheduleTask.getTask().description();
        assertThat(result1).isEqualTo(expected1);
        String expected2 = "description_2";
        String result2 = scheduleTask.getTask().description();
        assertThat(result2).isEqualTo(expected2);
        String expected3 = "description_1";
        String result3 = scheduleTask.getTask().description();
        assertThat(result3).isEqualTo(expected3);
    }

    @Test
    void whenTwoDepartmentHeadTaskThenManagerTask() {
        Comparator<Task> comparator = new TaskByPositionAsc()
                .thenComparing(new TaskByUrgencyDesc());
        ScheduleTask scheduleTask = new ScheduleTask(comparator);
        scheduleTask.addTask(new Task(DEPARTMENT_HEAD, "description_1", 7));
        scheduleTask.addTask(new Task(MANAGER, "description_2", 10));
        scheduleTask.addTask(new Task(DEPARTMENT_HEAD, "description_3", 7));
        List<Task> list = Arrays.asList(
            scheduleTask.getTask(),
            scheduleTask.getTask(),
            scheduleTask.getTask()
        );
        List<Task> expected = Arrays.asList(
            new Task(DEPARTMENT_HEAD, "description_1", 7),
            new Task(DEPARTMENT_HEAD, "description_3", 7),
            new Task(MANAGER, "description_2", 10)
        );
        assertThat(list).isEqualTo(expected);
    }
}