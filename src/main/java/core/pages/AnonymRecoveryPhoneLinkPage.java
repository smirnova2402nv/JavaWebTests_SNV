package core.pages;

import com.codeborne.selenide.SelenideElement;
import core.base.BasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class AnonymRecoveryPhoneLinkPage extends BasePage {
    private SelenideElement phoneField = $("[name='st.r.phone']");
    private SelenideElement countryDropdown = $("[class='it js-country-input']");
    private SelenideElement getСodeButton = $("[data-l='t,submit']");

    private SelenideElement errorMessage = $("[class='input-e js-ph-vl-hint']");
    {
        verifyPageElements();
    }

    @Step("Проверяем видимость всех элементов на странице: Укажите телефон")
    private void verifyPageElements() {
        phoneField.shouldBe(visible);
        countryDropdown.shouldBe(visible);
        getСodeButton.shouldBe(visible);
    }

    @Step("Выбираем код страны по названию: {countryName}")
    public String selectCountryByName(String countryName) {
        countryDropdown.click();
        SelenideElement countryItem = $(String.format(".country-select_i[data-name='%s']", countryName));
        countryItem.scrollTo();
        String countryCode = countryItem.find(".country-select_code").text();
        countryItem.click();
        return countryCode;

    }
    @Step("Нажимаем на кнопку Получить код")
    public void goToRecoveryByPhone() {
        getСodeButton.shouldBe(visible).click();
    }

    @Step("Проверяем видимость сообщения об ошибке входа")
    public boolean isErrorMessageVisible() {
        return errorMessage.shouldBe(visible).exists();
    }

    @Step("Получаем текст об ошибке входа")
    public String getErrorMessageText() {
        return errorMessage.shouldBe(visible).getText();
    }
}

