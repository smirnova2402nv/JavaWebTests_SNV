package core.pages.web;

import com.codeborne.selenide.SelenideElement;
import core.base.MobileBaseTest;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class AnonymRecoveryEmailLinkMobPage extends MobileBaseTest {
    private SelenideElement emailField = $("[name='email-input']");
    private SelenideElement getСodeButton = $("[name='email-submit-btn']");

    {
        verifyPageElements();
    }

    @Step("Проверяем видимость всех элементов на странице: Почта")
    private void verifyPageElements() {
        emailField.shouldBe(visible);
        getСodeButton.shouldBe(visible);
    }

    @Step("Нажимаем на кнопку Получить код")
    public void goToRecoveryByPhone() {
        getСodeButton.shouldBe(visible).click();
    }
}
