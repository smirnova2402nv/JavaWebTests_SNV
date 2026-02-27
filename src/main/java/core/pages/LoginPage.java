package core.pages;

import com.codeborne.selenide.SelenideElement;
import core.base.BasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage extends BasePage {

    private SelenideElement usernameField = $("[name='st.email']");
    private SelenideElement passwordField = $("[name='st.password']");
    private SelenideElement loginButton = $x("//span[text()='Войти']");
    private SelenideElement forgotPasswordLink = $x("//button[@aria-label='Не получается войти?']");
    private SelenideElement registrationButton = $x("//span[text()='Зарегистрироваться']");


    private SelenideElement vkButton = $("[data-l='t,vkc']");
    private SelenideElement yandexButton = $("[data-l='t,yandex']");
    private SelenideElement mailRuButton = $("[data-l='t,mailru']");

    private SelenideElement errorMessage = $x("//div[contains(@class,'LoginForm')]//span[contains(@class,'error')]");

    //public LoginPage
    {
        verifyPageElements();
    }

    @Step("Проверяем видимость всех элементов страницы")
    private void verifyPageElements() {
        usernameField.shouldBe(visible);
        passwordField.shouldBe(visible);
        loginButton.shouldBe(visible);
        forgotPasswordLink.shouldBe(visible);
        registrationButton.shouldBe(visible);
        vkButton.shouldBe(visible);
        yandexButton.shouldBe(visible);
        mailRuButton.shouldBe(visible);
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
        usernameField.shouldBe(visible).setValue(username);
        passwordField.shouldBe(visible).setValue(password);
        loginButton.shouldBe(visible).click();

    }

    @Step("Переходим на страницу восстановления пароля")
    public void openForgotPasswordPage() {
        forgotPasswordLink.shouldBe(visible).click();
    }

    @Step("Переходим на страницу регистрации")
    public void openRegistrationPage() {
        registrationButton.shouldBe(visible).click();
    }
/*
    @Step("Входим на сайт через VK")
    public void loginWithVK() {
        vkButton.shouldBe(visible).click();
    }

    @Step("Входим на сайт через Mail.ru")
    public void loginWithMailRu() {
        mailRuButton.shouldBe(visible).click();
    }

    @Step("Входим на сайт через Yandex")
    public void loginWithYandex() {
        yandexButton.shouldBe(visible).click();
    }
*/
}
