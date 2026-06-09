package core.pages.web;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class QrCodePage {
    private SelenideElement qrImage = $("[name='qr-placeholder']");

  /*  {
        verifyPageElements();
    }*/
    @Step("проверить, что отображается QR код\n")
    public void qrCodeVisible () {
        qrImage.shouldBe(visible);
    }
}
