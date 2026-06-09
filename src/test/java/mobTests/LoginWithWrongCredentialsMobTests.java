package tests;

import core.base.BaseTest;
import core.base.MobileBaseTest;
import core.pages.web.LoginMobPage;
import core.pages.web.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("skip_allure")
public class LoginWithWrongCredentialsMobTests extends MobileBaseTest {
    private static LoginMobPage loginMobPage;
    @BeforeEach
    public void prepare() {
        open(getBaseUrl());
        loginMobPage = new LoginMobPage();
    }

    @Test
    public void loginTest() {

        //Попытка входа с некорректными данными
        loginMobPage.login("incorrectUser","incorrectPassword");

        //Проверка наличия сообщения об ошибке
        assertTrue(loginMobPage.isErrorMessageVisible(), "Сообщение об ошибке входа не отображается");

        //Проверка текста сообщения об ошибке
        String expectedErrorMessage = "Пользователь с таким телефоном, почтой или логином не найден. Проверьте данные и попробуйте снова.";
        String actualErrorMessage = loginMobPage.getErrorMessageText();
        assertEquals(expectedErrorMessage, actualErrorMessage, "Текст сообщения об ошибке не совпадает");
    }

    @Test
    public void loginTestNotUsername() {

        //Попытка входа с некорректными данными
        loginMobPage.login("","incorrectPassword");

        //Проверка наличия сообщения об ошибке
        assertTrue(loginMobPage.isErrorMessageVisible(), "Сообщение об ошибке входа не отображается");

        //Проверка текста сообщения об ошибке
        String expectedErrorMessage = "Введите телефон, email или логин и пароль.";
        String actualErrorMessage = loginMobPage.getErrorMessageText();
        assertEquals(expectedErrorMessage, actualErrorMessage, "Текст сообщения об ошибке не совпадает");
    }

    @Test
    public void loginTestNotPassword() {

        //Попытка входа с некорректными данными
        loginMobPage.login("incorrectUser","");

        //Проверка наличия сообщения об ошибке
        assertTrue(loginMobPage.isErrorMessageVisible(), "Сообщение об ошибке входа не отображается");

        //Проверка текста сообщения об ошибке
        String expectedErrorMessage = "Введите телефон, email или логин и пароль.";
        String actualErrorMessage = loginMobPage.getErrorMessageText();
        assertEquals(expectedErrorMessage, actualErrorMessage, "Текст сообщения об ошибке не совпадает");
    }

}
