package ru.job4j.ex;

public class PasswordValidator {
    public static String validate(String password) {
        if (password == null) {
            throw new IllegalArgumentException("Пароль не может быть null");
        }
        if (password.length() < 8 || password.length() > 32) {
            return "Длина пароля должна находится в диапазоне [8, 32]";
        }

        boolean isContainsUpperCaseLetter = false;
        boolean isContainsLowerCaseLetter = false;
        boolean isContainsDigit = false;
        boolean isContainsSpecialSymbol = false;

        char[] symbols = password.toCharArray();
        for (char c : symbols) {
            if (Character.isUpperCase(c)) {
                isContainsUpperCaseLetter = true;
            }
            if (Character.isLowerCase(c)) {
                isContainsLowerCaseLetter = true;
            }
            if (Character.isDigit(c)) {
                isContainsDigit = true;
            }
            if (!Character.isLetterOrDigit(c)) {
                isContainsSpecialSymbol = true;
            }
        }

        if (!isContainsUpperCaseLetter) {
            return "Пароль должен содержать хотя бы один символ в верхнем регистре";
        }
        if (!isContainsLowerCaseLetter) {
            return "Пароль должен содержать хотя бы один символ в нижнем регистре";
        }
        if (!isContainsDigit) {
            return "Пароль должен содержать хотя бы одну цифру";
        }
        if (!isContainsSpecialSymbol) {
            return "Пароль должен содержать хотя бы один спец. символ (не цифра и не буква)";
        }

        String[] badSubStrings = {"qwerty", "12345", "password", "admin", "user"};
        password = password.toLowerCase();
        for (String badSubStr : badSubStrings) {
            if (password.contains(badSubStr)) {
                return "Пароль не должен содержать подстрок без учета регистра: "
                        + "qwerty, 12345, password, admin, user";
            }
        }

        return "Пароль валидный";
    }
}
