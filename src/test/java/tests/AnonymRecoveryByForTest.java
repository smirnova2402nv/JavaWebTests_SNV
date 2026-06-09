package tests;

import com.codeborne.selenide.SelenideElement;
import core.base.BaseTest;
import core.pages.web.AnonymRecoveryEmailLinkPage;
import core.pages.web.AnonymRecoveryPage;
import core.pages.web.AnonymRecoveryPhoneLinkPage;
import core.pages.web.LoginPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("skip_allure")
public class AnonymRecoveryByForTest extends BaseTest {

    private LoginPage loginPage;
    private AnonymRecoveryPage anonymRecoveryPage;
    private AnonymRecoveryEmailLinkPage anonymRecoveryEmailLinkPage;
    private AnonymRecoveryPhoneLinkPage anonymRecoveryPhoneLinkPage;

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
        loginPage.openForgotPasswordPage();

        anonymRecoveryPage = new AnonymRecoveryPage();
        anonymRecoveryPage.goToRecoveryByEmail();

        anonymRecoveryEmailLinkPage = new AnonymRecoveryEmailLinkPage();
    }

    @Test
    @Feature("Авторизация в одноклассниках")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Nadejda Smirnova")
    @DisplayName("Переход к восстановлению по телефону")
    public void setAnonymRecoveryPhoneLinkTest() {
        loginPage.openForgotPasswordPage();
        anonymRecoveryPage = new AnonymRecoveryPage();

        anonymRecoveryPage.goToRecoveryByPhone();
        anonymRecoveryPhoneLinkPage = new AnonymRecoveryPhoneLinkPage();

        String actualPhoneCode = anonymRecoveryPhoneLinkPage.selectCountryAndGetPhoneCode("Перу");

        assertEquals("+51", actualPhoneCode, "После выбора Перу в поле телефона должен подставиться код +51");
    }
        /*loginPage.openForgotPasswordPage();

        anonymRecoveryPage = new AnonymRecoveryPage();
        anonymRecoveryPage.goToRecoveryByPhone();

        anonymRecoveryPhoneLinkPage = new AnonymRecoveryPhoneLinkPage();

        String countryCode = anonymRecoveryPhoneLinkPage.selectCountryByName("Перу");
        assertEquals("+51", countryCode, "Код страны не совпадает с ожидаемым");
*/
       // anonymRecoveryPhoneLinkPage.goToRecoveryByPhone();
/* Баг
        assertTrue(
                anonymRecoveryPhoneLinkPage.isErrorMessageVisible(),
                "Сообщение об ошибке входа не отображается"
        );

        String expectedErrorMessage = "Неправильный номер телефона.";
        String actualErrorMessage = anonymRecoveryPhoneLinkPage.getErrorMessageText();

        assertEquals(
                expectedErrorMessage,
                actualErrorMessage,
                "Текст сообщения об ошибке не совпадает"
        );
*/
    }
