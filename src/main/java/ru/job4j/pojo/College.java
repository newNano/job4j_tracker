package ru.job4j.pojo;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Виктор");
        student.setGroup("ИВТ 1-21");
        student.setEntered("2021-07-11");
        System.out.println("Имя: " + student.getName() + System.lineSeparator()
                            + "Группа: " + student.getGroup() + System.lineSeparator()
                            + "Дата поступления: " + student.getEntered());
    }
}
