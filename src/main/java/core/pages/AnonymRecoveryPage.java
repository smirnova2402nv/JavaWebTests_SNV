package core.pages;

import com.codeborne.selenide.SelenideElement;
import core.base.BasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class AnonymRecoveryPage extends BasePage {

    private SelenideElement recoveryByFhoneButton = $("[data-l='t,phone']");
    private SelenideElement recoveryByEmailButton = $("[data-l='t,email']");
    private SelenideElement recoveryToSupportButton = $("[tsid='support-link_link_5998d4']");

    {
        verifyPageElements();
    }


    @Step("Проверяем видимость всех элементов на странице восстановления пароля")
    private void verifyPageElements() {
        recoveryByFhoneButton.shouldBe(visible);
        recoveryByEmailButton.shouldBe(visible);
        recoveryToSupportButton.shouldBe(visible);
    }

    @Step("Нажимаем кнопку восстановления через телефон")
    public void goToRecoveryByPhone() {
        recoveryByFhoneButton.shouldBe(visible).click();
    }
    @Step("Нажимаем кнопку восстановления через почту")
    public void goToRecoveryByEmail() {
        recoveryByEmailButton.shouldBe(visible).click();
    }
    @Step("Переходим к технической поддержке")
    public void goToSupport() {
        recoveryToSupportButton.shouldBe(visible).click();
    }
}
