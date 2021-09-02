package ru.job4j.oop;

public class DummyDic {
    public String engToRus(String eng) {
        String str = "Неизвестное слово: " + eng;
        return str;
    }

    public static void main(String[] args) {
        DummyDic dummyDic = new DummyDic();
        String engWord = "pen";
        String word = dummyDic.engToRus(engWord);
        System.out.println(word);
    }
}
