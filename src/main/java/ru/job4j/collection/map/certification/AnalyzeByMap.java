package ru.job4j.collection.map.certification;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double sumScore = 0.0;
        int countSubjects = 0;
        for (Pupil pupil : pupils) {
            sumScore += getSumScoreSubjectsPupil(pupil.subjects());
            countSubjects += getCountSubjectsPupil(pupil.subjects());
        }
        return sumScore / countSubjects;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> averageScoresByPupilsList = new ArrayList<>();
        for (Pupil pupil : pupils) {
            averageScoresByPupilsList.add(
                    new Label(pupil.name(), getAverageScorePupil(pupil.subjects()))
            );
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
        List<Label> sumScoresByPupilsList = new ArrayList<>();
        for (Pupil pupil : pupils) {
            sumScoresByPupilsList.add(
                    new Label(pupil.name(), getSumScoreSubjectsPupil(pupil.subjects()))
            );
        }
        sumScoresByPupilsList.sort(Comparator.naturalOrder());
        return sumScoresByPupilsList.get(sumScoresByPupilsList.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        List<Label> sumsScoresBySubjectsList = new ArrayList<>();
        Map<String, Integer> sumsScoreBySubject = getScoreBySubjectMap(pupils);
        for (Map.Entry<String, Integer> entry : sumsScoreBySubject.entrySet()) {
            sumsScoresBySubjectsList.add(
                    new Label(entry.getKey(), entry.getValue())
            );
        }
        sumsScoresBySubjectsList.sort(Comparator.naturalOrder());
        return sumsScoresBySubjectsList.get(sumsScoresBySubjectsList.size() - 1);
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
                sumsScoreBySubject.put(currentSubject, subject.score() + score);
            }
        }
        return sumsScoreBySubject;
    }

    public static double getSumScoreSubjectsPupil(List<Subject> subjects) {
        double sum = 0;
        for (Subject subject : subjects) {
            sum += subject.score();
        }
        return sum;
    }

    public static int getCountSubjectsPupil(List<Subject> subjects) {
        return subjects.size();
    }

    public static double getAverageScorePupil(List<Subject> subjects) {
        return getSumScoreSubjectsPupil(subjects) / getCountSubjectsPupil(subjects);
    }
}