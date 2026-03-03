package core.pages;

import com.codeborne.selenide.SelenideElement;
import core.base.BasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class AnonymRecoveryEmailLinkPage extends BasePage {
    private SelenideElement emailField = $("[id='field_email']");
    private SelenideElement getСodeButton = $("[data-l='t,submit']");

    {
        verifyPageElements();
    }

    @Step("Проверяем видимость всех элементов на странице: Почта")
    private void verifyPageElements() {
        emailField.shouldBe(visible);
        getСodeButton.shouldBe(visible);
    }

    @Step("Нажимаем на кнопку Получть код")
    public void goToRecoveryByPhone() {
        getСodeButton.shouldBe(visible).click();
    }
}
