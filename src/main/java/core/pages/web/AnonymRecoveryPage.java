package core.pages.web;

import com.codeborne.selenide.SelenideElement;
import core.base.BasePage;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class AnonymRecoveryPage extends BasePage {

    private SelenideElement recoveryByFhoneButton = $("[name='recovery-phone-label']");
    private SelenideElement recoveryByEmailButton = $("[name='recovery-email-btn']");
    private SelenideElement recoveryToSupportButton = $("[name='support-contact-btn']");
/* Устарело
    private SelenideElement supportChatVisible= $(".chat__n9ga2");
    private SelenideElement supportChatClose = $("[name='ico_close_16']");
    private SelenideElement supportChatCloseConfirm = $x("//span[text()='Да']");
*/

    public AnonymRecoveryPage() {
        // Ждем загрузки страницы
        $("body").shouldBe(visible, Duration.ofSeconds(10));
        verifyPageElements();
    }

    @Step("Проверяем видимость всех элементов на странице восстановления пароля")
    private void verifyPageElements() {
        recoveryByFhoneButton.shouldBe(visible);
        recoveryByEmailButton.shouldBe(visible);
        recoveryToSupportButton.shouldBe(visible);
    }
/* Баг
    @Step("проверить, что открылось окно для общения со службой поддержки")
    public void supportChatVisible() {
        supportChatVisible.shouldBe(visible);
    }

    @Step("нажать на крестик для закрытия чата")
    public void supportChatClose() {
        supportChatClose.shouldBe(visible).click();
    }

    @Step("подтвердить закрытие чата (Ващ вопрос точно решен?) нажатием на кнопку \"да\"")
    public void supportChatCloseConfirm() {
        supportChatCloseConfirm.shouldBe(visible).click();
    }
*/
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
