package core.pages.web;

import com.codeborne.selenide.SelenideElement;
import core.base.MobileBaseTest;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class AnonymRecoveryMobPage extends MobileBaseTest {

    private SelenideElement recoveryByFhoneButton = $("[name='recovery-phone-label']");
    private SelenideElement recoveryByEmailButton = $("[name='recovery-email-btn']");
    private SelenideElement recoveryToSupportButton = $("[name='support-contact-btn']");
/*
    public AnonymRecoveryPage() {
        // Ждем загрузки страницы
        $("body").shouldBe(visible, Duration.ofSeconds(10));
        verifyPageElements();
    }*/

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
