package ru.job4j.collection.map.certification;

import java.util.List;

public record Pupil(String name, List<Subject> subjects) {
    public double getSumScoreSubjects() {
        double sum = 0;
        for (Subject subject : subjects) {
            sum += subject.score();
        }
        return sum;
    }

    public int getCountSubjects() {
        return subjects.size();
    }

    public double getAverageScore() {
        return getSumScoreSubjects() / getCountSubjects();
    }
}
