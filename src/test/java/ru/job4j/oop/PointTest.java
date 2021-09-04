package ru.job4j.oop;

import org.junit.Test;

import static org.hamcrest.Matchers.closeTo;
import static org.junit.Assert.assertThat;

public class PointTest {

    @Test
    public void distanceLen4() {
        Point a = new Point(0, 0);
        Point b = new Point(4, 0);
        double result = a.distance(b);
        assertThat(result, closeTo(4, 0.001));
    }

    @Test
    public void distanceLen8Point062() {
        Point a = new Point(1, 3);
        Point b = new Point(8, 7);
        double result = a.distance(b);
        assertThat(result, closeTo(8.062, 0.001));
    }

    @Test
    public void distance3DMustBe5() {
        Point a = new Point(0, 0, 0);
        Point b = new Point(5, 0, 0);

        double result = a.distance3d(b);
        assertThat(result, closeTo(5, 0.001));
    }

    @Test
    public void distance3DMustbe7Point55() {
        Point a = new Point(1, 2, 3);
        Point b = new Point(5, 6, 8);

        double result = a.distance3d(b);
        assertThat(result, closeTo(7.55, 0.001));
    }
}