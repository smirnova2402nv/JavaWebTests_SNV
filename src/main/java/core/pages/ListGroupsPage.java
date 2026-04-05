package core.pages;

import com.codeborne.selenide.SelenideElement;
import core.base.BaseTest;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ListGroupsPage extends BaseTest {
    private SelenideElement listGroups = $(".anonym-user-groups");

    @Step("проверить, что выполнился переход к списку групп\n")
    public void listGroups () {
        listGroups.shouldBe(visible);
    }
}
