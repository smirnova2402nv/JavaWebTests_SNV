package core.pages.web;

import com.codeborne.selenide.SelenideElement;
import core.base.MobileBaseTest;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class AnonymRecoveryPhoneLinkMobPage extends MobileBaseTest {
    private SelenideElement phoneField = $("[name='phone-input']");
    private SelenideElement countryDropdown = $("[name='country-select']");
    private SelenideElement getСodeButton = $("[name='phone-submit-btn']");

    private final SelenideElement countrySelect = $("select");
    private final SelenideElement phoneInput = $$("input").first();

    {
        verifyPageElements();
    }

    @Step("Проверяем видимость всех элементов на странице: Укажите телефон")
    private void verifyPageElements() {
        phoneField.shouldBe(visible);
        countryDropdown.shouldBe(visible);
        getСodeButton.shouldBe(visible);
    }
    @Step("Подставляем страну в поиск и получаем код")
    public String selectCountryAndGetPhoneCode(String countryName) {
        countrySelect.selectOption(countryName);
        return phoneInput.getValue();
    }
    @Step("Нажимаем на кнопку Получить код")
    public void goToRecoveryByPhone() {
        getСodeButton.shouldBe(visible).click();
    }
}
