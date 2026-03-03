package tests;

import core.base.BaseTest;
import core.pages.AnonymRecoveryEmailLinkPage;
import core.pages.AnonymRecoveryPage;
import core.pages.AnonymRecoveryPhoneLinkPage;
import core.pages.LoginPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AnonymRecoveryByForTest extends BaseTest {
    private static LoginPage loginPage;
    private static AnonymRecoveryPage anonymRecoveryPage;
    private static AnonymRecoveryEmailLinkPage anonymRecoveryEmailLinkPage;
    private static AnonymRecoveryPhoneLinkPage anonymRecoveryPhoneLinkPage;

    @BeforeEach
    public void prepare() {
        open(getBaseUrl());
        loginPage = new LoginPage();
    }

    @Test
    @Feature("Авторизация в одноклассниках")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Nadejda Smirnova")
    @DisplayName("Переход к странице: Восстановление доступа")
    public void anonymRecoveryTest() {
        //Попытка входа с некорректными данными
        loginPage.login("incorrectUser", "incorrectPassword");

        for (int i = 1; i < 3; i++) {
            loginPage.clickLogin();
        }

        loginPage.goToRecovery();
        anonymRecoveryPage = new AnonymRecoveryPage();

    }

    @Test
    @Feature("Авторизация в одноклассниках")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Nadejda Smirnova")
    @DisplayName("Переход к восстановлению по почте")
    public void anonymRecoveryEmailLinkTest() {
        anonymRecoveryTest();
        anonymRecoveryPage.goToRecoveryByEmail();
        anonymRecoveryEmailLinkPage = new AnonymRecoveryEmailLinkPage();
    }


    @Test
    @Feature("Авторизация в одноклассниках")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Nadejda Smirnova")
    @DisplayName("Переход к восстановлению по телефону")
    public void setAnonymRecoveryPhoneLinkTest() {
        anonymRecoveryTest();
        anonymRecoveryPage.goToRecoveryByPhone();
        anonymRecoveryPhoneLinkPage = new AnonymRecoveryPhoneLinkPage();

        String countryCode = anonymRecoveryPhoneLinkPage.selectCountryByName("Перу");
        assertEquals("+51", countryCode, "Код страны не совпадает с ожидаемым");
        anonymRecoveryPhoneLinkPage.goToRecoveryByPhone();
        //Проверка наличия сообщения об ошибке
        assertTrue(anonymRecoveryPhoneLinkPage.isErrorMessageVisible(), "Сообщение об ошибке входа не отображается");

        //Проверка текста сообщения об ошибке
        String expectedErrorMessage = "Неправильный номер телефона.";
        String actualErrorMessage = anonymRecoveryPhoneLinkPage.getErrorMessageText();
        assertEquals(expectedErrorMessage, actualErrorMessage, "Текст сообщения об ошибке не совпадает");
    }

}
