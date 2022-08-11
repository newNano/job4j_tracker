package ru.job4j.ex;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PasswordValidatorTest {
    @Test
    public void whenThrowExceptionIfPasswordIsNull() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> PasswordValidator.validate(null)
        );
        assertThat(exception.getMessage()).isEqualTo("Пароль не может быть null");
    }

    @Test
    public void whenThrowExceptionPasswordLengthIsNotCorrect() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> PasswordValidator.validate("udbvrf7")
        );
        assertThat(exception.getMessage()).isEqualTo(
                "Длина пароля должна находится в диапазоне [8, 32]"
        );
    }

    @Test
    public void whenThrowExceptionPasswordNotContainsUpperCaseLetter() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> PasswordValidator.validate("password123")
        );
        assertThat(exception.getMessage()).isEqualTo(
                "Пароль должен содержать хотя бы один символ в верхнем регистре"
        );
    }

    @Test
    public void whenThrowExceptionPasswordNotContainsLowerCaseLetter() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> PasswordValidator.validate("PASSWORD12")
        );
        assertThat(exception.getMessage()).isEqualTo(
                "Пароль должен содержать хотя бы один символ в нижнем регистре"
        );
    }

    @Test
    public void whenThrowExceptionPasswordNotContainsDigit() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> PasswordValidator.validate("PASSWORDpassword$")
        );
        assertThat(exception.getMessage()).isEqualTo(
                "Пароль должен содержать хотя бы одну цифру"
        );
    }

    @Test
    public void whenThrowExceptionPasswordNotContainsSpecialSymbol() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> PasswordValidator.validate("PASSWORDpassword123")
        );
        assertThat(exception.getMessage()).isEqualTo(
                "Пароль должен содержать хотя бы один спец. символ (не цифра и не буква)"
        );
    }

    @Test
    public void whenThrowExceptionPasswordContainsSubstringQwerty() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> PasswordValidator.validate("QweRtYord123#")
        );
        assertThat(exception.getMessage()).isEqualTo(
                "Пароль не должен содержать подстрок без учета регистра: "
                        + "qwerty, 12345, password, admin, user"
        );
    }

    @Test
    public void whenPasswordIsValid() {
        String rsl = PasswordValidator.validate("smTHing39#");
        assertThat(rsl).isEqualTo("Пароль валидный");
    }
}