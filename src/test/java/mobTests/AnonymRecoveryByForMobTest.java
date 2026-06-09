package mobTests;

import core.base.MobileBaseTest;
import core.pages.web.AnonymRecoveryEmailLinkMobPage;
import core.pages.web.AnonymRecoveryMobPage;
import core.pages.web.AnonymRecoveryPhoneLinkMobPage;
import core.pages.web.LoginMobPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnonymRecoveryByForMobTest extends MobileBaseTest {
    private static LoginMobPage loginMobPage;
    private static AnonymRecoveryMobPage anonymRecoveryMobPage;
    private static AnonymRecoveryEmailLinkMobPage anonymRecoveryEmailLinkMobPage;
    private static AnonymRecoveryPhoneLinkMobPage anonymRecoveryPhoneLinkMobPage;

    @BeforeEach
    public void prepare() {
        open(getBaseUrl());

        loginMobPage = new LoginMobPage();
    }

    @Test
    @Feature("Авторизация в одноклассниках")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Nadejda Smirnova")
    @DisplayName("Переход к восстановлению по почте")
    public void anonymRecoveryEmailLinkTest() {
        loginMobPage.openForgotPasswordPage();

        anonymRecoveryMobPage = new AnonymRecoveryMobPage();
        anonymRecoveryMobPage.goToRecoveryByEmail();

        anonymRecoveryEmailLinkMobPage = new AnonymRecoveryEmailLinkMobPage();
    }

    @Test
    @Feature("Авторизация в одноклассниках")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Nadejda Smirnova")
    @DisplayName("Переход к восстановлению по телефону")
    public void setAnonymRecoveryPhoneLinkTest() {
        loginMobPage.openForgotPasswordPage();
        anonymRecoveryMobPage = new AnonymRecoveryMobPage();

        anonymRecoveryMobPage.goToRecoveryByPhone();
        anonymRecoveryPhoneLinkMobPage = new AnonymRecoveryPhoneLinkMobPage();

        String actualPhoneCode = anonymRecoveryPhoneLinkMobPage.selectCountryAndGetPhoneCode("Перу");

        assertEquals("+51", actualPhoneCode, "После выбора Перу в поле телефона должен подставиться код +51");
    }
}