package core.base;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class BasePage {

    //Примеры общих элемнтов, которые могут использоваться на разных страницах

    protected SelenideElement headerLogo = $("[tsid='toolbar_logo']");
    protected SelenideElement searchField = $x("//input[@name='st.query']");
    protected SelenideElement vkServices = $("[data-l='t,vk_ecosystem']");

    @Step("Выполняем поиск по сайту с запросом: {query}")
    public void search(String query) {
        searchField.shouldBe(visible).setValue(query).pressEnter();
    }

    @Step("Открываем VK Services")
    public void openVkServices() {
        vkServices.shouldBe(visible).click();
    }

    @Step("Кликаем на логотип OK")
    public void  clickLogo() {
        headerLogo.shouldBe(visible).click();
    }
    //Другие общие методы, например, для проверки загрузки страницы, авторизации и т.д.
}
