package ru.job4j.pojo;

public class College {
    public static void main(String[] args) {
        Student student1 = new Student();
        student1.setName("Виктор");
        student1.setGroup("ИВТ 1-21");
        student1.setEntered("2021-07-11");
        System.out.println("Имя: " + student1.getName() + "\n"
                            + "Группа: " + student1.getGroup() + "\n"
                            + "Дата поступления: " + student1.getEntered());
    }
}
