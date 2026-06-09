package core.pages.web;

import com.codeborne.selenide.SelenideElement;
import core.base.MobileBaseTest;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class LoginMobPage extends MobileBaseTest {

    private SelenideElement acceptCookies = $("[name='cookie-accept-btn']");
    private SelenideElement usernameField = $("[name='login-phone-email']");
    private SelenideElement passwordField = $("[name='login-password']");
    private SelenideElement loginButton = $("[name='login-submit-btn']");

    private SelenideElement forgotPasswordLink = $("[name='forgot-password-link']");
    private SelenideElement registrationButton = $("[name='hero-register-btn']");

    private SelenideElement errorMessage = $("[name='login-error']");

    private SelenideElement goToQrCodeButton = $("[name='tab-qr']");
    private SelenideElement searchGroups = $("[name='search-input']");

    private SelenideElement goToRecoveryButton = $("[name='lockout-recover-btn']");
/*
    public LoginPage() {
        $("body").shouldBe(visible, Duration.ofSeconds(10));
    }*/


    @Step("Проверяем видимость всех элементов страницы")
    public void verifyPageElements() {
        usernameField.shouldBe(visible);
        passwordField.shouldBe(visible);
        loginButton.shouldBe(visible);
        forgotPasswordLink.shouldBe(visible);
        registrationButton.shouldBe(visible);
    }

    @Step("Проверяем видимость сообщения об ошибке входа")
    public boolean isErrorMessageVisible() {
        return errorMessage.shouldBe(visible).exists();
    }

    @Step("Получаем текст об ошибке входа")
    public String getErrorMessageText() {
        return errorMessage.shouldBe(visible).getText();
    }

    @Step("Входим на сайт с логином: {username} и {password}")
    public void login(String username, String password) {
        usernameField.shouldBe(visible).click();
        usernameField.setValue(username);

        passwordField.shouldBe(visible).click();
        passwordField.setValue(password);

        clickLogin();
    }

    @Step("Нажимаем кнопку Войти")
    public void clickLogin() {
        loginButton
                .shouldBe(visible, Duration.ofSeconds(10))
                .shouldBe(enabled, Duration.ofSeconds(20))
                .shouldNotHave(cssClass("vkuiButton__loading"), Duration.ofSeconds(20))
                .click();
    }

    @Step("Нажимаем восстановить пароль")
    public void goToRecovery() {
        goToRecoveryButton.shouldBe(visible).click();
    }

    @Step("Нажать обратиться в службу поддержки")
    public void openForgotPasswordPage() {
        forgotPasswordLink.shouldBe(visible).click();
    }

    @Step("Переходим во вкладку QR-код")
    public void goToQrCodeButton() {
        goToQrCodeButton.shouldBe(visible, clickable).click();
    }

    @Step("Вверху в поле поиск ввести Тестировщик")
    public void shouldRedirectToGroups() {
        searchGroups.sendKeys("Тестировщик");
    }

    @Step("Переходим на страницу регистрации")
    public void openRegistrationPage() {
        registrationButton.shouldBe(visible).click();
    }
}