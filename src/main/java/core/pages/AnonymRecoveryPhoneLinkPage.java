package core.pages;

import com.codeborne.selenide.SelenideElement;
import core.base.BasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class AnonymRecoveryPhoneLinkPage extends BasePage {
    private SelenideElement fhoneField = $("[name='st.r.phone']");
    private SelenideElement countryField = $("[class='it js-country-input']");
    private SelenideElement getСodeButton = $("[data-l='t,submit']");
    {
        verifyPageElements();
    }

    @Step("Проверяем видимость всех элементов на странице: Укажите телефон")
    private void verifyPageElements() {
        fhoneField.shouldBe(visible);
        countryField.shouldBe(visible);
        getСodeButton.shouldBe(visible);
    }

    @Step("Нажимаем на кнопку Получть код")
    public void goToRecoveryByPhone() {
        getСodeButton.shouldBe(visible).click();
    }
}

