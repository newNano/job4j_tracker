package ru.job4j.stream.javaapi.optional;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class College {
    private final Map<Student, Set<Subject>> students;

    public College(Map<Student, Set<Subject>> students) {
        this.students = students;
    }

    public Optional<Student> findByAccount(String account) {
        return students.keySet()
                .stream()
                .filter(student -> student.getAccount().equals(account))
                .findFirst();
    }

    public Optional<Subject> findBySubjectName(String account, String name) {
        Optional<Student> studentOptional = findByAccount(account);
        return studentOptional.flatMap(student -> students.get(student)
                .stream()
                .filter(subject -> subject.getName().equals(name))
                .findFirst());
    }
}