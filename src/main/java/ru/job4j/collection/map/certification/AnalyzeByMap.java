package ru.job4j.collection.map.certification;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double sumScore = 0.0;
        int countSubjects = 0;
        for (Pupil pupil : pupils) {
            sumScore += pupil.getSumScoreSubjects();
            countSubjects += pupil.getCountSubjects();
        }
        return sumScore / countSubjects;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> averageScoresByPupilsList = new ArrayList<>();
        for (Pupil pupil : pupils) {
            averageScoresByPupilsList.add(new Label(pupil.name(), pupil.getAverageScore()));
        }
        return averageScoresByPupilsList;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        int countPupils = pupils.size();
        List<Label> averageScoresBySubjectsList = new ArrayList<>();
        Map<String, Integer> sumsScoreBySubject = getScoreBySubjectMap(pupils);
        for (Map.Entry<String, Integer> entry : sumsScoreBySubject.entrySet()) {
            averageScoresBySubjectsList.add(
                    new Label(entry.getKey(), entry.getValue() / countPupils)
            );
        }
        return averageScoresBySubjectsList;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        Map<Double, Label> bestStudent = new HashMap<>();
        double maxScore = 0.0;
        for (Pupil pupil : pupils) {
            double sumScoresPupil = pupil.getSumScoreSubjects();
            if (sumScoresPupil > maxScore) {
                maxScore = sumScoresPupil;
            }
            bestStudent.put(
                    sumScoresPupil,
                    new Label(pupil.name(), sumScoresPupil)
            );
        }
        return bestStudent.get(maxScore);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> sumsScoreBySubject = getScoreBySubjectMap(pupils);
        int maxScore = 0;
        String nameSubject = null;
        for (Map.Entry<String, Integer> entry : sumsScoreBySubject.entrySet()) {
            if (entry.getValue() > maxScore) {
                maxScore = entry.getValue();
                nameSubject = entry.getKey();
            }
        }
        return new Label(nameSubject, maxScore);
    }

    public static Map<String, Integer> getScoreBySubjectMap(List<Pupil> pupils) {
        Map<String, Integer> sumsScoreBySubject = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            List<Subject> subjectList = pupil.subjects();
            for (Subject subject : subjectList) {
                int score = 0;
                String currentSubject = subject.name();
                if (sumsScoreBySubject.containsKey(currentSubject)) {
                    score = sumsScoreBySubject.get(currentSubject);
                }
                sumsScoreBySubject.put(subject.name(), subject.score() + score);
            }
        }
        return sumsScoreBySubject;
    }
}