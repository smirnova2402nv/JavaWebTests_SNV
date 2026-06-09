package tests;

import core.base.BaseTest;
import core.pages.web.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("skip_allure")
public class LoginWithWrongCredentialsTests extends BaseTest {
    private static LoginPage loginPage;
    @BeforeEach
    public void prepare() {
        open(getBaseUrl());
        loginPage = new LoginPage();
    }

    @Test
    public void loginTest() {

        //Попытка входа с некорректными данными
        loginPage.login("incorrectUser","incorrectPassword");

        //Проверка наличия сообщения об ошибке
        assertTrue(loginPage.isErrorMessageVisible(), "Сообщение об ошибке входа не отображается");

        //Проверка текста сообщения об ошибке
        String expectedErrorMessage = "Пользователь с таким телефоном, почтой или логином не найден. Проверьте данные и попробуйте снова.";
        String actualErrorMessage = loginPage.getErrorMessageText();
        assertEquals(expectedErrorMessage, actualErrorMessage, "Текст сообщения об ошибке не совпадает");
    }

    @Test
    public void loginTestNotUsername() {

        //Попытка входа с некорректными данными
        loginPage.login("","incorrectPassword");

        //Проверка наличия сообщения об ошибке
        assertTrue(loginPage.isErrorMessageVisible(), "Сообщение об ошибке входа не отображается");

        //Проверка текста сообщения об ошибке
        String expectedErrorMessage = "Введите телефон, email или логин и пароль.";
        String actualErrorMessage = loginPage.getErrorMessageText();
        assertEquals(expectedErrorMessage, actualErrorMessage, "Текст сообщения об ошибке не совпадает");
    }

    @Test
    public void loginTestNotPassword() {

        //Попытка входа с некорректными данными
        loginPage.login("incorrectUser","");

        //Проверка наличия сообщения об ошибке
        assertTrue(loginPage.isErrorMessageVisible(), "Сообщение об ошибке входа не отображается");

        //Проверка текста сообщения об ошибке
        String expectedErrorMessage = "Введите телефон, email или логин и пароль.";
        String actualErrorMessage = loginPage.getErrorMessageText();
        assertEquals(expectedErrorMessage, actualErrorMessage, "Текст сообщения об ошибке не совпадает");
    }

}
