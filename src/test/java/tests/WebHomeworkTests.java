package tests;

import core.base.BaseTest;
import core.pages.web.AnonymRecoveryPage;
import core.pages.web.LoginPage;
import core.pages.web.QrCodePage;
import io.qameta.allure.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class WebHomeworkTests extends BaseTest {
    private static LoginPage loginPage;
    private static AnonymRecoveryPage anonymRecoveryPage;
    private static QrCodePage qrCodePage;

    @BeforeEach
    @Step("открыть страницу ok.ru")
    public void prepare() {
        open(getBaseUrl());
        loginPage = new LoginPage();
    }

    @Test
    @Feature("Домашнее задание WEB")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Nadejda Smirnova")
    @DisplayName("Проверка входа по QR коду")
    public void qrCodeVisibilityValidationTest() {
        loginPage.goToQrCodeButton();
        qrCodePage = new QrCodePage();
        qrCodePage.qrCodeVisible();
    }
/*
    @Test
    @Feature("Домашнее задание WEB")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Nadejda Smirnova")
    @DisplayName("Переход к службе поддержки")
    public void shouldOpenSupportChatAndCloseSuccessfullyTest() {
        loginPage.openForgotPasswordPage();
        anonymRecoveryPage = new AnonymRecoveryPage();
        anonymRecoveryPage.goToSupport();
        /* Баг
        anonymRecoveryPage.supportChatVisible();
        anonymRecoveryPage.supportChatClose();
        anonymRecoveryPage.supportChatCloseConfirm();

         */
    }

