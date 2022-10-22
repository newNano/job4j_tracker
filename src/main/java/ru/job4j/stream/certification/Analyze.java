package ru.job4j.stream.certification;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analyze {
    public static double averageScore(Stream<Pupil> stream) {
        return stream.flatMap(pupil -> pupil.subjects().stream())
                .mapToInt(Subject::score)
                .average()
                .getAsDouble();
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream.collect(Collectors
                .toMap(Pupil::name, pupil -> averageScore(Stream.of(pupil))))
                .entrySet().stream()
                .map(entry -> new Tuple(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream.flatMap(pupil -> pupil.subjects().stream())
                .collect(
                        Collectors.groupingBy(Subject::name,
                                              Collectors.averagingDouble(Subject::score))
                )
                .entrySet().stream()
                .map(entry -> new Tuple(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream.collect(Collectors.toMap(Pupil::name, pupil -> pupil.subjects().stream()
                                                                .mapToDouble(Subject::score)
                                                                .sum()))
                .entrySet().stream()
                .max(Comparator.comparing(Map.Entry::getValue))
                .map(entry -> new Tuple(entry.getKey(), entry.getValue()))
                .orElse(null);
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream.flatMap(pupil -> pupil.subjects().stream())
                .collect(Collectors.groupingBy(Subject::name,
                                                Collectors.summingDouble(Subject::score)))
                .entrySet().stream()
                .max(Comparator.comparing(Map.Entry::getValue))
                .map(entry -> new Tuple(entry.getKey(), entry.getValue()))
                .orElse(null);
    }
}